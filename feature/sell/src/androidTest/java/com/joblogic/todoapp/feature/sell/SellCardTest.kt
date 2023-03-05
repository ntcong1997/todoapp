package com.joblogic.todoapp.feature.sell

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.joblogic.todoapp.core.model.Sell
import com.joblogic.todoapp.core.testing.data.sellsTestData
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */

class SellCardTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun sellCard_with_full_info() {
        val sell = sellsTestData.first()

        composeTestRule.setContent {
            SellCard(sell = sell)
        }

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_name)}: ${sell.name.orEmpty()}")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_price)}: ${sell.price ?: ""}")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_quantity)}: ${sell.quantity ?: ""}")
            .assertExists()
    }

    @Test
    fun sellCard_with_some_field_null() {
        val sell = Sell(
            id = null,
            name = null,
            price = null,
            quantity = null
        )

        composeTestRule.setContent {
            SellCard(sell = sell)
        }

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_name)}: ")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_price)}: ")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_quantity)}: ")
            .assertExists()
    }
}