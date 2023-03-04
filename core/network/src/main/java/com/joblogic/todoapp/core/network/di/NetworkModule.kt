package com.joblogic.todoapp.core.network.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton
import com.joblogic.todoapp.core.network.BuildConfig
import com.joblogic.todoapp.core.network.TdaNetworkDataSource
import com.joblogic.todoapp.core.network.retrofit.RetrofitTdaNetwork

/**
 * Created by TC on 03/03/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, 10 * 1024 * 1024) // cache size = 10MB

    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache, logging: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder().cache(cache)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(logging)
        }
        return builder.build()
    }

    @Provides
    fun provideTdaNetworkDataSource(
        networkJson: Json,
        okHttpClient: OkHttpClient
    ): TdaNetworkDataSource = RetrofitTdaNetwork(networkJson, okHttpClient)
}