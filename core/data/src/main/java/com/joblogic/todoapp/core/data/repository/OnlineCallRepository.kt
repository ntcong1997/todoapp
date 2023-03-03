package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.data.model.toCall
import com.joblogic.todoapp.core.model.Call
import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import javax.inject.Inject

/**
 * Created by TC on 03/03/2023.
 */

class OnlineCallRepository @Inject constructor(
    private val tdaNetworkDataSource: TdaNetworkDataSource
) : CallRepository {
    override suspend fun getCalls(): List<Call> =
        tdaNetworkDataSource.getCalls().map {
            it.toCall()
        }
}