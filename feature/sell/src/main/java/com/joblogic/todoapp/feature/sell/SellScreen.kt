package com.joblogic.todoapp.feature.sell

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
fun SellRoute(
    viewModel: SellViewModel = hiltViewModel()
) {
    val sellsUiState = viewModel.sellsUiState.collectAsState()
    val isRefreshing = viewModel.isRefreshing.collectAsState()

    SellScreen(
        sellsUiState = sellsUiState.value,
        isRefreshing = isRefreshing.value,
        onSellsRefresh = viewModel::refreshSells
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SellScreen(
    sellsUiState: SellsUiState,
    isRefreshing: Boolean,
    onSellsRefresh: () -> Unit

) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onSellsRefresh
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
            sells(sellsUiState = sellsUiState)
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

fun LazyListScope.sells(
    sellsUiState: SellsUiState
) {
    when (sellsUiState) {
        is SellsUiState.Loading, is SellsUiState.Error -> Unit
        is SellsUiState.Success -> {
            val sells = sellsUiState.sells
            items(
                items = sells,
                key = {
                    it.id ?: UUID.randomUUID().toString()
                }
            ) {
                SellCard(sell = it)
            }
        }
    }
}