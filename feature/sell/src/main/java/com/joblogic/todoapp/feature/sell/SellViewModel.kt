package com.joblogic.todoapp.feature.sell

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joblogic.todoapp.core.common.result.Result
import com.joblogic.todoapp.core.common.result.asResult
import com.joblogic.todoapp.core.domain.usecase.GetSellsUseCase
import com.joblogic.todoapp.core.domain.usecase.SyncSellsUseCase
import com.joblogic.todoapp.core.model.Sell
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by TC on 04/03/2023.
 */

@HiltViewModel
class SellViewModel @Inject constructor(
    private val getSellsUseCase: GetSellsUseCase,
    private val syncSellsUseCase: SyncSellsUseCase
) : ViewModel() {
    val sellsUiState = sellsUiState()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), SellsUiState.Loading)

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    private fun sellsUiState(): Flow<SellsUiState> {
        return getSellsUseCase()
            .asResult()
            .map {
                when (it) {
                    is Result.Success -> {
                        val sells = it.data
                        SellsUiState.Success(sells)
                    }
                    is Result.Loading -> SellsUiState.Loading
                    is Result.Error -> SellsUiState.Error
                }
            }
    }

    fun refreshSells() {
        viewModelScope.launch {
            _isRefreshing.value = true
            syncSellsUseCase(Unit)
            _isRefreshing.value = false
        }
    }
}

sealed interface SellsUiState {
    data class Success(val sells: List<Sell>) : SellsUiState
    object Error : SellsUiState
    object Loading : SellsUiState
}