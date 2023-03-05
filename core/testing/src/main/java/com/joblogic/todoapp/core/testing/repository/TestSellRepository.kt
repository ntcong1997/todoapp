package com.joblogic.todoapp.core.testing.repository

import com.joblogic.todoapp.core.data.Synchronizer
import com.joblogic.todoapp.core.data.repository.SellRepository
import com.joblogic.todoapp.core.model.Sell
import com.joblogic.todoapp.core.testing.data.sellsTestData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by TC on 05/03/2023.
 */

class TestSellRepository : SellRepository {
    override fun getSells(): Flow<List<Sell>> {
        return flow {
            emit(sellsTestData)
        }
    }

    override suspend fun syncSells() {

    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean = true
}