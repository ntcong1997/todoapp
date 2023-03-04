package com.joblogic.todoapp.feature.call

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joblogic.todoapp.core.model.Call
import java.util.UUID

/**
 * Created by TC on 04/03/2023.
 */

@Composable
fun CallRoute(
    viewModel: CallViewModel = hiltViewModel()
) {
    val callsUiState = viewModel.callsUiState.collectAsState()
    val isRefreshing = viewModel.isRefreshing.collectAsState()

    CallScreen(
        callsUiState = callsUiState.value,
        isRefreshing = isRefreshing.value,
        onCallsRefresh = viewModel::refreshCalls
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CallScreen(
    callsUiState: CallsUiState,
    isRefreshing: Boolean,
    onCallsRefresh: () -> Unit

) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onCallsRefresh
    )

    Box(modifier = Modifier
        .pullRefresh(pullRefreshState)
        .background(Color.White)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            calls(callsUiState = callsUiState)
        }

        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(
                Alignment.TopCenter
            )
        )
    }
}

fun LazyListScope.calls(
    callsUiState: CallsUiState
) {
    when (callsUiState) {
        is CallsUiState.Loading, is CallsUiState.Error -> Unit
        is CallsUiState.Success -> {
            val calls = callsUiState.calls
            items(
                items = calls,
                key = {
                    it.id ?: UUID.randomUUID().toString()
                }
            ) {
                CallCard(call = it)
            }
        }
    }
}