package com.joblogic.todoapp.core.data.network

import com.joblogic.todoapp.core.database.dao.SellDao
import com.joblogic.todoapp.core.database.model.SellEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created by TC on 04/03/2023.
 */
class TestSellDao : SellDao {
    private val sellEntitiesStateFlow = MutableStateFlow<List<SellEntity>>(listOf())

    override fun getSellEntities(): Flow<List<SellEntity>> = sellEntitiesStateFlow

    override suspend fun insertOrReplaceSellEntities(sellEntities: List<SellEntity>) {
        sellEntitiesStateFlow.value = sellEntities
    }

    override suspend fun deleteSellEntities() {
        sellEntitiesStateFlow.value = listOf()
    }
}