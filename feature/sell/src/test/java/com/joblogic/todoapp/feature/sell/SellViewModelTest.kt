package com.joblogic.todoapp.feature.sell

import com.joblogic.todoapp.core.domain.usecase.GetSellsUseCase
import com.joblogic.todoapp.core.domain.usecase.SyncSellsUseCase
import com.joblogic.todoapp.core.testing.data.sellsTestData
import com.joblogic.todoapp.core.testing.repository.TestSellRepository
import com.joblogic.todoapp.core.testing.util.MainDispatcherRule
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 05/03/2023.
 */

class SellViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val sellRepository = TestSellRepository()

    private lateinit var viewModel: SellViewModel

    @Before
    fun setup() {
        viewModel = SellViewModel(
            getSellsUseCase = GetSellsUseCase(
                sellRepository,
            ),
            syncSellsUseCase = SyncSellsUseCase(
                sellRepository,
                mainDispatcherRule.testDispatcher
            )
        )
    }

    @Test
    fun `init get sells`() = runTest {
        val collectValues = mutableListOf<SellsUiState>()
        val collectJob = launch(mainDispatcherRule.testDispatcher) { viewModel.sellsUiState.toList(collectValues) }

        assertEquals(
            listOf(
                SellsUiState.Loading,
                SellsUiState.Success(sellsTestData)
            ),
            collectValues.toList()
        )

        collectJob.cancel()
    }
}