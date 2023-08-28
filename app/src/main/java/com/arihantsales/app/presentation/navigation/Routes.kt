package com.arihantsales.app.presentation.navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object MainContent : Routes("mainContent")
    object SignUp : Routes("signup")
    object ProductList : Routes("product_list_screen")
    object ProductDetail : Routes("product_detail_screen")
}