package com.joblogic.todoapp.ui

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.joblogic.todoapp.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import com.joblogic.todoapp.feature.call.R as callR

/**
 * Created by TC on 05/03/2023.
 */

@HiltAndroidTest
class NavigationTest {
    /**
     * Manages the components' state and is used to perform injection on your test
     */
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    /**
     * Use the primary activity to initialize the app normally.
     */
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun firstScreen_isCall() {
        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(callR.string.text_call))
            .assertIsSelected()
    }
}