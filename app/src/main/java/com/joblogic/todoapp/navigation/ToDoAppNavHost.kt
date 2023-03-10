package com.joblogic.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joblogic.todoapp.feature.buy.navigation.buyScreen
import com.joblogic.todoapp.feature.call.navigation.callRoute
import com.joblogic.todoapp.feature.call.navigation.callScreen
import com.joblogic.todoapp.feature.sell.navigation.sellScreen

/**
 * Created by TC on 04/03/2023.
 */

@Composable
fun ToDoAppNavHost(
    navController: NavHostController,
    startDestination: String = callRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        callScreen()
        buyScreen()
        sellScreen()
    }
}