package com.joblogic.todoapp.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.joblogic.todoapp.core.network.model.NetworkBuySell
import com.joblogic.todoapp.core.network.model.NetworkCall
import retrofit2.http.GET
import com.joblogic.todoapp.core.network.BuildConfig
import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by TC on 03/03/2023.
 */

private const val TdaBaseUrl = BuildConfig.BACKEND_DOMAIN

private interface RetrofitTdaNetworkApi {
    @GET(value = "imkhan334/demo-1/call")
    suspend fun getCalls(): List<NetworkCall>

    @GET(value = "imkhan334/demo-1/buy")
    suspend fun getBuySell(): List<NetworkBuySell>
}

@Singleton
class RetrofitTdaNetwork @Inject constructor(
    networkJson: Json,
    okHttpClient: OkHttpClient
) : TdaNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl("https://$TdaBaseUrl")
        .addConverterFactory(
            @OptIn(ExperimentalSerializationApi::class)
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .client(okHttpClient)
        .build()
        .create(RetrofitTdaNetworkApi::class.java)

    override suspend fun getCalls(): List<NetworkCall> =
        networkApi.getCalls()

    override suspend fun getBuySell(): List<NetworkBuySell> =
        networkApi.getBuySell()
}

