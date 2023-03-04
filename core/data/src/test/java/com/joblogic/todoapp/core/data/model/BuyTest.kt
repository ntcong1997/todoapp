package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.network.model.NetworkItem
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class BuyTest {
    @Test
    fun `NetworkItem map to Buy`() {
        val networkItem = NetworkItem(
            id = 1,
            name = "Macbook",
            price = 2000,
            quantity = 5,
            type = 1
        )
        val buy = networkItem.toBuy()

        assertEquals(1, buy.id)
        assertEquals("Macbook", buy.name)
        assertEquals(2000, buy.price)
        assertEquals(5, buy.quantity)
    }
}