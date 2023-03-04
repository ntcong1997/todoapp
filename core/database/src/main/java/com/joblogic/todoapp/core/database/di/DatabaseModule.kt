package com.joblogic.todoapp.core.database.di

import android.content.Context
import androidx.room.Room
import com.joblogic.todoapp.core.database.TdaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by TC on 04/03/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesTdaDatabase(
        @ApplicationContext context: Context,
    ): TdaDatabase = Room.databaseBuilder(
        context,
        TdaDatabase::class.java,
        TdaDatabase.DATABASE_NAME,
    ).build()
}