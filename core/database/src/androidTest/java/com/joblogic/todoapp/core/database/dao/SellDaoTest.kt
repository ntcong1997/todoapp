package com.joblogic.todoapp.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.joblogic.todoapp.core.database.TdaDatabase
import com.joblogic.todoapp.core.database.model.SellEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 05/03/2023.
 */

class SellDaoTest {
    private lateinit var sellDao: SellDao
    private lateinit var database: TdaDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            TdaDatabase::class.java
        ).build()
        sellDao = database.sellDao()
    }

    @Test
    fun insert_sell_entities() = runTest {
        val sellEntities = listOf(
            SellEntity(
                sellId = 1,
                name = "Macbook",
                price = 200000,
                quantity = 1
            ),
            SellEntity(
                sellId = 2,
                name = "iPhone",
                price = 50000,
                quantity = 2
            )
        )
        sellDao.insertOrReplaceSellEntities(sellEntities)

        assertEquals(listOf(
            SellEntity(
                sellId = 1,
                name = "Macbook",
                price = 200000,
                quantity = 1,
                id = 1
            ),
            SellEntity(
                sellId = 2,
                name = "iPhone",
                price = 50000,
                quantity = 2,
                id = 2
            )
        ), sellDao.getSellEntities().first())
    }

    @Test
    fun insert_or_replace_sell_entities_with_same_sell_id() = runTest {
        sellDao.insertOrReplaceSellEntities(listOf(
            SellEntity(
                sellId = 1,
                name = "Macbook",
                price = 200000,
                quantity = 1
            )
        ))
        sellDao.insertOrReplaceSellEntities(listOf(
            SellEntity(
                sellId = 1,
                name = "iPhone",
                price = 50000,
                quantity = 2
            )
        ))
        assertEquals(listOf(
            SellEntity(
                sellId = 1,
                name = "iPhone",
                price = 50000,
                quantity = 2,
                id = 2
            )
        ), sellDao.getSellEntities().first())
    }

    @Test
    fun delete_all_sell_entities() = runTest {
        val sellEntities = listOf(
            SellEntity(
                sellId = 1,
                name = "Macbook",
                price = 200000,
                quantity = 1
            ),
            SellEntity(
                sellId = 2,
                name = "iPhone",
                price = 50000,
                quantity = 2
            )
        )
        sellDao.insertOrReplaceSellEntities(sellEntities)
        sellDao.deleteSellEntities()

        assertEquals(listOf(), sellDao.getSellEntities().first())
    }
}