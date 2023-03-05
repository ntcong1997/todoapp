package com.joblogic.todoapp.feature.sell

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import com.joblogic.todoapp.core.testing.data.sellsTestData
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */
class SellScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun sellsUiStateSuccess() {
        val sells = sellsTestData

        composeTestRule.setContent {
            SellScreen(
                sellsUiState = SellsUiState.Success(sells),
                isRefreshing = false,
                onSellsRefresh = {}
            )
        }

        sells.forEach {
            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_name)}: ${it.name.orEmpty()}")
                .assertCountEquals(sells.filter { sell -> sell.name == it.name }.size)

            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_price)}: ${it.price ?: ""}")
                .assertCountEquals(sells.filter { sell -> sell.price == it.price }.size)

            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_quantity)}: ${it.quantity ?: ""}")
                .assertCountEquals(sells.filter { sell -> sell.quantity == it.quantity }.size)
        }
    }
}