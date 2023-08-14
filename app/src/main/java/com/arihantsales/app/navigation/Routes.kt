package com.arihantsales.app.navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object MainContent : Routes("mainContent")
    object SignUp : Routes("signup")
}