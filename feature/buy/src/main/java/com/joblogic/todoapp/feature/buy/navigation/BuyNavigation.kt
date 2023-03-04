package com.joblogic.todoapp.feature.buy.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.joblogic.todoapp.feature.buy.BuyRoute

/**
 * Created by TC on 04/03/2023.
 */

const val buyRoute = "buy_route"

fun NavController.navigateToBuy(navOptions: NavOptions? = null) {
    this.navigate(buyRoute, navOptions)
}

fun NavGraphBuilder.buyScreen() {
    composable(route = buyRoute) {
        BuyRoute()
    }
}