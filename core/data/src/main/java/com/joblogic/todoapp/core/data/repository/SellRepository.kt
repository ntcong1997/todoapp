package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.Syncable
import com.joblogic.todoapp.core.model.Sell
import kotlinx.coroutines.flow.Flow

/**
 * Created by TC on 03/03/2023.
 */

interface SellRepository : Syncable {
    fun getSells(): Flow<List<Sell>>

    suspend fun syncSells()
}