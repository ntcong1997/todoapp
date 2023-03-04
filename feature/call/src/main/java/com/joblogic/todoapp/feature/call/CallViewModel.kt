package com.joblogic.todoapp.feature.call

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joblogic.todoapp.core.domain.usecase.GetCallsUseCase
import com.joblogic.todoapp.core.model.Call
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import com.joblogic.todoapp.core.common.result.Result
import kotlinx.coroutines.launch

/**
 * Created by TC on 04/03/2023.
 */

@HiltViewModel
class CallViewModel @Inject constructor(
    private val getCallsUseCase: GetCallsUseCase
) : ViewModel() {
    private val _callsUiState = MutableStateFlow<CallsUiState>(CallsUiState.Loading)
    val callsUiState = _callsUiState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    init {
        viewModelScope.launch {
            callsUiState()
        }
    }

    private suspend fun callsUiState() {
        _callsUiState.value = CallsUiState.Loading
        val resultGetCalls = getCallsUseCase(Unit)
        if (resultGetCalls is Result.Success) _callsUiState.value = CallsUiState.Success(resultGetCalls.data)
        else _callsUiState.value = CallsUiState.Error
    }

    fun refreshCalls() {
        viewModelScope.launch {
            _isRefreshing.value = true
            callsUiState()
            _isRefreshing.value = false
        }
    }
}

sealed interface CallsUiState {
    data class Success(val calls: List<Call>) : CallsUiState
    object Error : CallsUiState
    object Loading : CallsUiState
}