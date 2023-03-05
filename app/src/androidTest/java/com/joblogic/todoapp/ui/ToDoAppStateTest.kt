package com.joblogic.todoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

/**
 * Created by TC on 05/03/2023.
 */

class ToDoAppStateTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var state: ToDoAppState

    @Test
    fun toDoAppState_currentDestination() = runTest {
        var currentDestination: String? = null

        composeTestRule.setContent {
            val navController = rememberTestNavController()
            state = rememberToDoAppState(
                navController = navController
            )

            // Update currentDestination whenever it changes
            currentDestination = state.currentDestination?.route

            // Navigate to destination call once
            LaunchedEffect(Unit) {
                navController.setCurrentDestination("buy")
            }
        }

        assertEquals("buy", currentDestination)
    }

    @Test
    fun toDoAppState_destinations() = runTest {
        composeTestRule.setContent {
            state = rememberToDoAppState()
        }

        assertEquals(3, state.topLevelDestinations.size)
        assertTrue(state.topLevelDestinations[0].name.contains("call", true))
        assertTrue(state.topLevelDestinations[1].name.contains("buy", true))
        assertTrue(state.topLevelDestinations[2].name.contains("sell", true))
    }
}

@Composable
private fun rememberTestNavController(): TestNavHostController {
    val context = LocalContext.current
    val navController = remember {
        TestNavHostController(context).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
            graph = createGraph(startDestination = "call") {
                composable("call") { }
                composable("buy") { }
                composable("sell") { }
            }
        }
    }
    return navController
}