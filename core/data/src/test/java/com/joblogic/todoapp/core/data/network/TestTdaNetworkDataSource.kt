package com.joblogic.todoapp.core.data.network

import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import com.joblogic.todoapp.core.network.model.NetworkCall
import com.joblogic.todoapp.core.network.model.NetworkItem

/**
 * Created by TC on 04/03/2023.
 */
class TestTdaNetworkDataSource : TdaNetworkDataSource {
    private val networkCalls = listOf(
        NetworkCall(
            id = 1,
            name = "Jason White",
            number = "9993456665"
        ),
        NetworkCall(
            id = 2,
            name = "Eden Hazard",
            number = "0123456789"
        )
    )

    private val networkItems = listOf(
        NetworkItem(
            id = 1,
            name = "MacBook Pro",
            price = 205000,
            quantity = 1,
            type = 1
        ),
        NetworkItem(
            id = 2,
            name = "iPad",
            price = 20000,
            quantity = 4,
            type = 2
        )
    )

    override suspend fun getCalls(): List<NetworkCall> {
        return networkCalls
    }

    override suspend fun getItems(): List<NetworkItem> {
        return networkItems
    }
}