package com.joblogic.todoapp.feature.call

import com.joblogic.todoapp.core.domain.usecase.GetCallsUseCase
import com.joblogic.todoapp.core.testing.data.callsTestData
import com.joblogic.todoapp.core.testing.repository.TestCallRepository
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

class CallViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val callRepository = TestCallRepository()

    private lateinit var viewModel: CallViewModel

    @Before
    fun setup() {
        viewModel = CallViewModel(
            getCallsUseCase = GetCallsUseCase(callRepository, mainDispatcherRule.testDispatcher)
        )
    }

    @Test
    fun `init get calls`() = runTest {
        val collectValues = mutableListOf<CallsUiState>()
        val collectJob = launch(mainDispatcherRule.testDispatcher) { viewModel.callsUiState.toList(collectValues) }

        // Why collectValues has only one element success
        // Maybe when we collect callsUiState it already passed Loading state
        assertEquals(
            listOf(CallsUiState.Success(callsTestData)),
            collectValues.toList()
        )

        collectJob.cancel()
    }

    @Test
    fun `refresh calls`() = runTest {
        val collectValues = mutableListOf<CallsUiState>()
        val collectJob = launch(mainDispatcherRule.testDispatcher) { viewModel.callsUiState.toList(collectValues) }
        viewModel.refreshCalls()

        assertEquals(
            listOf(
                CallsUiState.Success(callsTestData),
                CallsUiState.Loading,
                CallsUiState.Success(callsTestData)
            ),
            collectValues.toList()
        )

        collectJob.cancel()
    }
}