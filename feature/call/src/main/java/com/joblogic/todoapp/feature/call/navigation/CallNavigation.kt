package com.joblogic.todoapp.feature.call.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.joblogic.todoapp.feature.call.CallRoute

/**
 * Created by TC on 04/03/2023.
 */

const val callRoute = "call_route"

fun NavController.navigateToCall(navOptions: NavOptions? = null) {
    this.navigate(callRoute, navOptions)
}

fun NavGraphBuilder.callScreen() {
    composable(route = callRoute) {
        CallRoute()
    }
}