package com.joblogic.todoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.joblogic.todoapp.feature.buy.navigation.navigateToBuy
import com.joblogic.todoapp.feature.call.navigation.navigateToCall
import com.joblogic.todoapp.feature.sell.navigation.navigateToSell
import com.joblogic.todoapp.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

/**
 * Created by TC on 04/03/2023.
 */

@Composable
fun rememberToDoAppState(
    navController: NavHostController = rememberNavController()
): ToDoAppState {
    return remember(navController) {
        ToDoAppState(navController)
    }
}

class ToDoAppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.CALL -> navController.navigateToCall(topLevelNavOptions)
            TopLevelDestination.BUY -> navController.navigateToBuy(topLevelNavOptions)
            TopLevelDestination.SELL -> navController.navigateToSell(topLevelNavOptions)
        }
    }
}