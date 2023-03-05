package com.joblogic.todoapp.feature.buy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joblogic.todoapp.core.domain.usecase.GetBuysUseCase
import com.joblogic.todoapp.core.model.Buy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import com.joblogic.todoapp.core.common.result.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by TC on 04/03/2023.
 */

@HiltViewModel
class BuyViewModel @Inject constructor(
    private val getBuysUseCase: GetBuysUseCase
) : ViewModel() {
    private val _buysUiState = MutableStateFlow<BuysUiState>(BuysUiState.Loading)
    val buysUiState = _buysUiState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    init {
        viewModelScope.launch {
            buysUiState()
        }
    }

    private suspend fun buysUiState() {
        _buysUiState.value = BuysUiState.Loading
        val resultGetBuys = getBuysUseCase(Unit)
        if (resultGetBuys is Result.Success) _buysUiState.value =
            BuysUiState.Success(resultGetBuys.data)
        else _buysUiState.value = BuysUiState.Error
    }

    fun refreshBuys() {
        viewModelScope.launch {
            _isRefreshing.value = true
            buysUiState()
            _isRefreshing.value = false
        }
    }
}

sealed interface BuysUiState {
    data class Success(val buys: List<Buy>) : BuysUiState
    object Error : BuysUiState
    object Loading : BuysUiState
}