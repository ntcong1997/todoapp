package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.model.toBuy
import com.joblogic.todoapp.core.data.network.TestTdaNetworkDataSource
import com.joblogic.todoapp.core.network.model.ItemType
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class OnlineBuyRepositoryTest {
    private lateinit var buyRepository: OnlineBuyRepository

    private lateinit var tdaNetworkDataSource: TestTdaNetworkDataSource

    @Before
    fun setup() {
        tdaNetworkDataSource = TestTdaNetworkDataSource()
        buyRepository = OnlineBuyRepository(tdaNetworkDataSource)
    }

    @Test
    fun `get buys from network`() = runTest {
        assertEquals(
            tdaNetworkDataSource
                .getItems()
                .filter { it.itemType == ItemType.BUY }
                .map { it.toBuy() },
            buyRepository.getBuys()
        )
    }
}