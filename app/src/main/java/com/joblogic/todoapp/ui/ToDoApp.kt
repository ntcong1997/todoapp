package com.joblogic.todoapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.joblogic.todoapp.core.designsystem.theme.BlueRibbon
import com.joblogic.todoapp.core.designsystem.theme.GraySilverChalice
import com.joblogic.todoapp.navigation.ToDoAppNavHost
import com.joblogic.todoapp.navigation.TopLevelDestination

/**
 * Created by TC on 04/03/2023.
 */

@Composable
fun ToDoApp(
    appState: ToDoAppState = rememberToDoAppState()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            contentColor = MaterialTheme.colors.onBackground,
            bottomBar = {
                ToDoAppBottomNavigation(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        PaddingValues(
                            0.dp,
                            0.dp,
                            0.dp,
                            it.calculateBottomPadding()
                        )
                    )
            ) {
                ToDoAppNavHost(navController = appState.navController)
            }
        }
    }
}

@Composable
private fun ToDoAppBottomNavigation(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            ToDoAppBottomNavigationItem(
                icon = destination.icon,
                iconTextId = destination.iconTextId,
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination)
                }
            )
        }
    }
}

@Composable
fun RowScope.ToDoAppBottomNavigationItem(
    icon: ImageVector,
    iconTextId: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        },
        label = {
            Text(
                text = stringResource(id = iconTextId),
                fontSize = 10.sp,
                maxLines = 1
            )
        },
        selectedContentColor = BlueRibbon,
        unselectedContentColor = GraySilverChalice,
        selected = selected,
        onClick = onClick
    )
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false