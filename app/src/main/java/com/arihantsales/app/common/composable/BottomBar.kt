package com.arihantsales.app.common.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arihantsales.app.presentation.navigation.BottomBarScreen

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorite,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(
        modifier = Modifier.height(60.dp)
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
) {
    if (currentDestination != null) {
        NavigationBarItem(
//            label = {
//                Text(
//                    text = screen.title,
//                    style = MaterialTheme.typography.labelSmall
//                )
//            },
            icon = {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.title,
                    modifier = Modifier.size(30.dp)
                )
            },
            selected = currentDestination.hierarchy.any {
                it.route == screen.route
            },
            onClick = {
                navController.navigate(screen.route)
                {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        )
    }
}