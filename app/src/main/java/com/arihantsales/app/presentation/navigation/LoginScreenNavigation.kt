package com.arihantsales.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arihantsales.app.presentation.screens.MainScreen
import com.arihantsales.app.presentation.screens.login_screen.LoginPage
import com.arihantsales.app.presentation.screens.signup_screen.SignUp

@Composable
fun LoginScreenNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Routes.MainContent.route) {
            MainScreen()
        }
        composable(Routes.SignUp.route) {
            SignUp(navController)
        }
    }
}