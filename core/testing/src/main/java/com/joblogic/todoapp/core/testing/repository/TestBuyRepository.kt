package com.joblogic.todoapp.core.testing.repository

import com.joblogic.todoapp.core.data.repository.BuyRepository
import com.joblogic.todoapp.core.model.Buy
import com.joblogic.todoapp.core.testing.data.buysTestData

/**
 * Created by TC on 05/03/2023.
 */

class TestBuyRepository : BuyRepository {
    override suspend fun getBuys(): List<Buy> {
        return buysTestData
    }
}