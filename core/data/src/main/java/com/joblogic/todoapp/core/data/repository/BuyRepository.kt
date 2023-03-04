package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.model.BuyItem

/**
 * Created by TC on 03/03/2023.
 */

interface BuyRepository {
    suspend fun getBuys(): List<BuyItem>
}