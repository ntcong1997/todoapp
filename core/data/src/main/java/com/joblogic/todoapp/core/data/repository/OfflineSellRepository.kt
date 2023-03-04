package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.Synchronizer
import com.joblogic.todoapp.core.data.model.toSell
import com.joblogic.todoapp.core.data.model.toSellEntity
import com.joblogic.todoapp.core.data.suspendRunCatching
import com.joblogic.todoapp.core.database.dao.SellDao
import com.joblogic.todoapp.core.model.Sell
import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import com.joblogic.todoapp.core.network.model.ItemType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by TC on 04/03/2023.
 */

class OfflineSellRepository @Inject constructor(
    private val sellDao: SellDao,
    private val tdaNetworkDataSource: TdaNetworkDataSource
) : SellRepository {
    override fun getSells(): Flow<List<Sell>> {
        return sellDao.getSellEntities().map {
            it.map {
                it.toSell()
            }
        }
    }

    override suspend fun syncSells() {
        val networkSells = tdaNetworkDataSource.getItem().filter {
            it.itemType == ItemType.SELL
        }
        sellDao.deleteSellEntities()
        sellDao.insertOrReplaceSellEntities(networkSells.map { it.toSellEntity() })
    }


    override suspend fun syncWith(synchronizer: Synchronizer): Boolean =
        suspendRunCatching {
            syncSells()
        }.isSuccess
}