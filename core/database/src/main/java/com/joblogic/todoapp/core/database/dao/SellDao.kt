package com.joblogic.todoapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joblogic.todoapp.core.database.model.SellEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by TC on 04/03/2023.
 */

@Dao
interface SellDao {
    @Query(value = "SELECT * FROM ItemToSell")
    fun getSellEntities(): Flow<List<SellEntity>>

    /**
     * Inserts [sellEntities] into the db if they don't exist, and replace those that do
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceSellEntities(sellEntities: List<SellEntity>)

    @Query(value = "DELETE FROM ItemToSell")
    suspend fun deleteSellEntities()
}