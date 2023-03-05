package com.joblogic.todoapp.feature.call

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import com.joblogic.todoapp.core.testing.data.callsTestData
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */

class CallScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun callsUiStateSuccess() {
        val calls = callsTestData

        composeTestRule.setContent {
            CallScreen(
                callsUiState = CallsUiState.Success(calls),
                isRefreshing = false,
                onCallsRefresh = {}
            )
        }

        calls.forEach {
            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_name)}: ${it.name.orEmpty()}")
                .assertCountEquals(calls.filter { call -> call.name == it.name }.size)

            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_number)}: ${it.number.orEmpty()}")
                .assertCountEquals(calls.filter { call -> call.number == it.number }.size)
        }
    }
}