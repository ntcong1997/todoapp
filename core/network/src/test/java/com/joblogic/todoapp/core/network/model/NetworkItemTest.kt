package com.joblogic.todoapp.core.network.model

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class NetworkItemTest {
    @Test
    fun `NetworkItem with item type is buy`() {
        val networkItem = NetworkItem(
            id = null,
            name = null,
            price = null,
            quantity = null,
            type = 1
        )

        assertEquals(ItemType.BUY, networkItem.itemType)
    }

    @Test
    fun `NetworkItem with item type is sell`() {
        val networkItem = NetworkItem(
            id = null,
            name = null,
            price = null,
            quantity = null,
            type = 2
        )

        assertEquals(ItemType.SELL, networkItem.itemType)
    }

    @Test
    fun `NetworkItem with item type is unknown`() {
        val networkItem = NetworkItem(
            id = null,
            name = null,
            price = null,
            quantity = null,
            type = null
        )

        assertEquals(ItemType.UNKNOWN, networkItem.itemType)
    }
}