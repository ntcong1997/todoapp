package com.joblogic.todoapp.feature.buy

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import java.util.*

/**
 * Created by TC on 04/03/2023.
 */

@Composable
fun BuyRoute(
    viewModel: BuyViewModel = hiltViewModel()
) {
    val buysUiState = viewModel.buysUiState.collectAsState()
    val isRefreshing = viewModel.isRefreshing.collectAsState()

    BuyScreen(
        buysUiState = buysUiState.value,
        isRefreshing = isRefreshing.value,
        onBuysRefresh = viewModel::refreshBuys
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BuyScreen(
    buysUiState: BuysUiState,
    isRefreshing: Boolean,
    onBuysRefresh: () -> Unit

) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onBuysRefresh
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
            buys(buysUiState = buysUiState)
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

fun LazyListScope.buys(
    buysUiState: BuysUiState
) {
    when (buysUiState) {
        is BuysUiState.Loading, is BuysUiState.Error -> Unit
        is BuysUiState.Success -> {
            val buys = buysUiState.buys
            items(
                items = buys,
                key = {
                    it.id ?: UUID.randomUUID().toString()
                }
            ) {
                BuyCard(buy = it)
            }
        }
    }
}