package com.arihantsales.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arihantsales.app.presentation.screens.navigation_screens.FavoriteScreen
import com.arihantsales.app.presentation.screens.navigation_screens.HomeScreen
import com.arihantsales.app.presentation.screens.navigation_screens.ProfileScreen

@Composable
fun SetUpNavigation(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route){
            FavoriteScreen(navController)
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen(navController)
        }
    }

}