package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.model.toCall
import com.joblogic.todoapp.core.data.network.TestTdaNetworkDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */
class OnlineCallRepositoryTest {
    private lateinit var callRepository: OnlineCallRepository

    private lateinit var tdaNetworkDataSource: TestTdaNetworkDataSource

    @Before
    fun setup() {
        tdaNetworkDataSource = TestTdaNetworkDataSource()
        callRepository = OnlineCallRepository(tdaNetworkDataSource)
    }

    @Test
    fun `get calls from network`() = runTest {
        assertEquals(
            tdaNetworkDataSource
                .getCalls()
                .map { it.toCall() },
            callRepository.getCalls()
        )
    }
}