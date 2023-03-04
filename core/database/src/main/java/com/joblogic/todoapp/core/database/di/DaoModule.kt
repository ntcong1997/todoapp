package com.joblogic.todoapp.core.database.di

import com.joblogic.todoapp.core.database.TdaDatabase
import com.joblogic.todoapp.core.database.dao.SellDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by TC on 04/03/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    fun providesSellDao(
        database: TdaDatabase,
    ): SellDao = database.sellDao()
}