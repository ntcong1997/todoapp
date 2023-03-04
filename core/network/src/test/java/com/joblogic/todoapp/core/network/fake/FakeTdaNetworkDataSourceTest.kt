package com.joblogic.todoapp.core.network.fake

import com.joblogic.todoapp.core.network.model.NetworkCall
import com.joblogic.todoapp.core.network.model.NetworkItem
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class FakeTdaNetworkDataSourceTest {
    private lateinit var fakeTdaNetworkDataSource: FakeTdaNetworkDataSource

    private val testDispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalSerializationApi::class)
    @Before
    fun setup() {
        fakeTdaNetworkDataSource = FakeTdaNetworkDataSource(
            ioDispatcher = testDispatcher,
            networkJson = Json {
                ignoreUnknownKeys = true
                explicitNulls = false
            }
        )
    }

    @Test
    fun `Deserialization Of Call`() = runTest {
        assertEquals(
            NetworkCall(
                id = 1,
                name = "Jason White",
                number = "9993456665"
            ),
            fakeTdaNetworkDataSource.getCalls().first()
        )
    }

    @Test
    fun `Deserialization Of Item`() = runTest {
        assertEquals(
            NetworkItem(
                id = 1,
                name = "MacBook Pro",
                price = 205000,
                quantity = 1,
                type = 1
            ),
            fakeTdaNetworkDataSource.getItems().first()
        )
    }
}