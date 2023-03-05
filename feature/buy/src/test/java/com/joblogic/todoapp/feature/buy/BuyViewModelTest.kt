package com.joblogic.todoapp.feature.buy

import com.joblogic.todoapp.core.domain.usecase.GetBuysUseCase
import com.joblogic.todoapp.core.testing.data.buysTestData
import com.joblogic.todoapp.core.testing.repository.TestBuyRepository
import com.joblogic.todoapp.core.testing.util.MainDispatcherRule
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 05/03/2023.
 */

class BuyViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val buyRepository = TestBuyRepository()

    private lateinit var viewModel: BuyViewModel

    @Before
    fun setup() {
        viewModel = BuyViewModel(
            getBuysUseCase = GetBuysUseCase(buyRepository, mainDispatcherRule.testDispatcher)
        )
    }

    @Test
    fun `init get buys`() = runTest {
        val collectValues = mutableListOf<BuysUiState>()
        val collectJob = launch(mainDispatcherRule.testDispatcher) { viewModel.buysUiState.toList(collectValues) }

        // Why collectValues has only one element success
        // Maybe when we collect buysUiState it already passed Loading state
        assertEquals(
            listOf(BuysUiState.Success(buysTestData)),
            collectValues.toList()
        )

        collectJob.cancel()
    }

    @Test
    fun `refresh buys`() = runTest {
        val collectValues = mutableListOf<BuysUiState>()
        val collectJob = launch(mainDispatcherRule.testDispatcher) { viewModel.buysUiState.toList(collectValues) }
        viewModel.refreshBuys()

        assertEquals(
            listOf(
                BuysUiState.Success(buysTestData),
                BuysUiState.Loading,
                BuysUiState.Success(buysTestData)
            ),
            collectValues.toList()
        )

        collectJob.cancel()
    }
}