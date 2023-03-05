package com.joblogic.todoapp.feature.buy

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.joblogic.todoapp.core.model.Buy
import com.joblogic.todoapp.core.testing.data.buysTestData
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */

class BuyCardTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun buyCard_with_full_info() {
        val buy = buysTestData.first()

        composeTestRule.setContent {
            BuyCard(buy = buy)
        }

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_name)}: ${buy.name.orEmpty()}")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_price)}: ${buy.price ?: ""}")
            .assertExists()

        composeTestRule
            .onNodeWithText("${composeTestRule.activity.getString(R.string.text_quantity)}: ${buy.quantity ?: ""}")
            .assertExists()
    }

    @Test
    fun buyCard_with_some_field_null() {
        val buy = Buy(
            id = null,
            name = null,
            price = null,
            quantity = null
        )

        composeTestRule.setContent {
            BuyCard(buy = buy)
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