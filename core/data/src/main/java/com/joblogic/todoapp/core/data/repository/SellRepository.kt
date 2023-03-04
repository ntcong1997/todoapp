package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.model.Sell

/**
 * Created by TC on 03/03/2023.
 */

interface SellRepository {
    suspend fun getSells(): List<Sell>
}