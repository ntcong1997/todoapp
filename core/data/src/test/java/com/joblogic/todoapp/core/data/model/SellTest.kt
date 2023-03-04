package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.database.model.SellEntity
import com.joblogic.todoapp.core.network.model.NetworkItem
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class SellTest {
    @Test
    fun `NetworkItem map to SellEntity`() {
        val networkItem = NetworkItem(
            id = 1,
            name = "Macbook",
            price = 2000,
            quantity = 5,
            type = 2
        )
        val sellEntity = networkItem.toSellEntity()

        assertEquals(1, sellEntity.sellId)
        assertEquals("Macbook", sellEntity.name)
        assertEquals(2000, sellEntity.price)
        assertEquals(5, sellEntity.quantity)
    }

    @Test
    fun `SellEntity map to Sell`() {
        val sellEntity = SellEntity(
            sellId = 1,
            name = "Macbook",
            price = 2000,
            quantity = 5
        )
        val sell = sellEntity.toSell()

        assertEquals(1, sell.id)
        assertEquals("Macbook", sell.name)
        assertEquals(2000, sell.price)
        assertEquals(5, sell.quantity)
    }
}