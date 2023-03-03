package com.joblogic.todoapp.core.data.di

import com.joblogic.todoapp.core.data.repository.BuyRepository
import com.joblogic.todoapp.core.data.repository.CallRepository
import com.joblogic.todoapp.core.data.repository.OnlineBuyRepository
import com.joblogic.todoapp.core.data.repository.OnlineCallRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by TC on 03/03/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsCallRepository(
        onlineCallRepository: OnlineCallRepository
    ) : CallRepository

    @Binds
    fun bindsBuyRepository(
        onlineBuyRepository: OnlineBuyRepository
    ) : BuyRepository
}