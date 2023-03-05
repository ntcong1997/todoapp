package com.joblogic.todoapp.feature.call

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import com.joblogic.todoapp.core.model.Call
import com.joblogic.todoapp.core.testing.data.callsTestData
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */

class CallCardTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun callCard_with_full_info() {
        val call = callsTestData.first()

        composeTestRule.setContent {
            CallCard(call = call)
        }

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_name)}: ${call.name.orEmpty()}")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_number)}: ${call.number.orEmpty()}")
            .assertExists()
    }

    @Test
    fun callCard_with_some_field_null() {
        val call = Call(
            id = null,
            name = null,
            number = null
        )

        composeTestRule.setContent {
            CallCard(call = call)
        }

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_name)}: ")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_number)}: ")
            .assertExists()
    }
}