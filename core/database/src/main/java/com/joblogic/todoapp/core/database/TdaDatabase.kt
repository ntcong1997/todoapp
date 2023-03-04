package com.joblogic.todoapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joblogic.todoapp.core.database.dao.SellDao
import com.joblogic.todoapp.core.database.model.SellEntity

/**
 * Created by TC on 04/03/2023.
 */

@Database(entities = [SellEntity::class], version = 1)
abstract class TdaDatabase : RoomDatabase() {
    abstract fun sellDao(): SellDao

    companion object {
        const val DATABASE_NAME = "tda-database"
    }
}