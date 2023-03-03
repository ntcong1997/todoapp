package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.model.toBuy
import com.joblogic.todoapp.core.model.Buy
import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import javax.inject.Inject

/**
 * Created by TC on 03/03/2023.
 */

class OnlineBuyRepository @Inject constructor(
    private val tdaNetworkDataSource: TdaNetworkDataSource
) : BuyRepository {
    override suspend fun getBuys(): List<Buy> =
        tdaNetworkDataSource.getBuySell()
            .filter { it.type == 1 }
            .map { it.toBuy() }
}