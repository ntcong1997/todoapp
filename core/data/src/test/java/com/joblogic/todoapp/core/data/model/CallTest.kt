package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.network.model.NetworkCall
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by TC on 04/03/2023.
 */

class CallTest {
    @Test
    fun `NetworkCall map to Call`() {
        val networkCall = NetworkCall(
            id = 1,
            name = "Eden Hazard",
            number = "0123456789"
        )
        val call = networkCall.toCall()

        assertEquals(1, call.id)
        assertEquals("Eden Hazard", call.name)
        assertEquals("0123456789", call.number)
    }
}