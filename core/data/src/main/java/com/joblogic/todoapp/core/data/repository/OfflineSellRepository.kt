package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.model.Sell
import javax.inject.Inject

/**
 * Created by TC on 04/03/2023.
 */

class OfflineSellRepository @Inject constructor(

) : SellRepository {
    override suspend fun getSells(): List<Sell> {
        return listOf()
    }
}