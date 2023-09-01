package com.arihantsales.app.presentation.screens.navigation_screens.homescreen



import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arihantsales.app.presentation.navigation.Routes

@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.ProductList.route
    ){
        composable(route = Routes.ProductList.route){
            ProductListScreen(navController)
        }
    }
}