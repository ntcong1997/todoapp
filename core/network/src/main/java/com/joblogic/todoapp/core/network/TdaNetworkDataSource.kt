package com.joblogic.todoapp.core.network

import com.joblogic.todoapp.core.network.model.NetworkItem
import com.joblogic.todoapp.core.network.model.NetworkCall

/**
 * Created by TC on 03/03/2023.
 */
interface TdaNetworkDataSource {
    suspend fun getCalls(): List<NetworkCall>

    suspend fun getItem(): List<NetworkItem>
}