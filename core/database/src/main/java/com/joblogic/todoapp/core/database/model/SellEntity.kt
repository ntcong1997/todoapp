package com.joblogic.todoapp.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Created by TC on 04/03/2023.
 */

@Entity(
    tableName = "ItemToSell",
    indices = [Index(value = ["sell_id"], unique = true)]
)
data class SellEntity(
    @ColumnInfo(name = "sell_id") val sellId: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "price") val price: Long?,
    @ColumnInfo(name = "quantity") val quantity: Int?,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
