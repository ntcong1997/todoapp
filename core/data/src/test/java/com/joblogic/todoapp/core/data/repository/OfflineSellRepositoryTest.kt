package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.model.toSell
import com.joblogic.todoapp.core.data.model.toSellEntity
import com.joblogic.todoapp.core.data.network.TestSellDao
import com.joblogic.todoapp.core.data.network.TestSynchronizer
import com.joblogic.todoapp.core.data.network.TestTdaNetworkDataSource
import com.joblogic.todoapp.core.network.model.ItemType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class OfflineSellRepositoryTest {
    private lateinit var sellRepository: OfflineSellRepository

    private lateinit var sellDao: TestSellDao

    private lateinit var tdaNetworkDataSource: TestTdaNetworkDataSource

    private lateinit var synchronizer: TestSynchronizer

    @Before
    fun setup() {
        sellDao = TestSellDao()
        tdaNetworkDataSource = TestTdaNetworkDataSource()
        synchronizer = TestSynchronizer()
        sellRepository = OfflineSellRepository(sellDao, tdaNetworkDataSource)
    }

    @Test
    fun `get sells from database`() = runTest {
        assertEquals(
            listOf(),
            sellRepository.getSells().first()
        )
    }

    @Test
    fun `sync sells from network`() = runTest {
        sellRepository.syncWith(synchronizer)

        assertEquals(
            tdaNetworkDataSource
                .getItems()
                .filter { it.itemType == ItemType.SELL }
                .map { it.toSellEntity() }
                .map { it.toSell() },
            sellRepository.getSells().first()
        )
    }
}