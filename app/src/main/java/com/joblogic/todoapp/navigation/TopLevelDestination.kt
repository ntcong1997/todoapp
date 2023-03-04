package com.joblogic.todoapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.joblogic.todoapp.core.designsystem.icon.ToDoAppIcons
import com.joblogic.todoapp.feature.call.R as callR
import com.joblogic.todoapp.feature.buy.R as buyR

/**
 * Created by TC on 04/03/2023.
 */

enum class TopLevelDestination(
    val icon: ImageVector,
    val iconTextId: Int
) {
    CALL(
        icon = ToDoAppIcons.Call,
        iconTextId = callR.string.text_call
    ),
    BUY(
        icon = ToDoAppIcons.Buy,
        iconTextId = buyR.string.text_buy
    )
}