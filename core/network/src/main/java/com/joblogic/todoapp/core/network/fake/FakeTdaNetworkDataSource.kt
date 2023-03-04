package com.joblogic.todoapp.core.network.fake

import JvmUnitTestFakeAssetManager
import com.joblogic.todoapp.core.common.network.Dispatcher
import com.joblogic.todoapp.core.common.network.ToDoAppDispatchers
import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import com.joblogic.todoapp.core.network.model.NetworkCall
import com.joblogic.todoapp.core.network.model.NetworkItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

/**
 * [TdaNetworkDataSource] implementation that provides static news resources to aid development
 */
class FakeTdaNetworkDataSource @Inject constructor(
    @Dispatcher(ToDoAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : TdaNetworkDataSource {

    companion object {
        private const val CALLS_ASSET = "calls.json"
        private const val ITEMS_ASSET = "items.json"
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getCalls(): List<NetworkCall> =
        withContext(ioDispatcher) {
            assets.open(CALLS_ASSET).use(networkJson::decodeFromStream)
        }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getItems(): List<NetworkItem> =
        withContext(ioDispatcher) {
            assets.open(ITEMS_ASSET).use(networkJson::decodeFromStream)
        }
}
