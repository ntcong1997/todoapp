package com.joblogic.todoapp.feature.sell.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.joblogic.todoapp.feature.sell.SellRoute

/**
 * Created by TC on 04/03/2023.
 */

const val sellRoute = "sell_route"

fun NavController.navigateToSell(navOptions: NavOptions? = null) {
    this.navigate(sellRoute, navOptions)
}

fun NavGraphBuilder.sellScreen() {
    composable(route = sellRoute) {
        SellRoute()
    }
}