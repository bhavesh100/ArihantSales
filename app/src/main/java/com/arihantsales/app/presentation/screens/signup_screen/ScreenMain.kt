package com.arihantsales.app.presentation.screens.signup_screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arihantsales.app.presentation.navigation.Routes
import com.arihantsales.app.presentation.screens.MainContent
import com.arihantsales.app.presentation.screens.login_screen.LoginPage

@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Routes.MainContent.route) {
            MainContent()
        }
        composable(Routes.SignUp.route) {
            SignUp(navController)
        }
    }
}