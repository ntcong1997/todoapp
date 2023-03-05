package com.joblogic.todoapp.feature.buy

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import com.joblogic.todoapp.core.testing.data.buysTestData
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */
class BuyScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun buysUiStateSuccess() {
        val buys = buysTestData

        composeTestRule.setContent {
            BuyScreen(
                buysUiState = BuysUiState.Success(buys),
                isRefreshing = false,
                onBuysRefresh = {}
            )
        }

        buys.forEach {
            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_name)}: ${it.name.orEmpty()}")
                .assertCountEquals(buys.filter { buy -> buy.name == it.name }.size)

            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_price)}: ${it.price ?: ""}")
                .assertCountEquals(buys.filter { buy -> buy.price == it.price }.size)

            composeTestRule
                .onAllNodesWithText("${composeTestRule.activity.getString(R.string.text_quantity)}: ${it.quantity ?: ""}")
                .assertCountEquals(buys.filter { buy -> buy.quantity == it.quantity }.size)
        }
    }
}