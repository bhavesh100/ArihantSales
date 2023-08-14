package com.arihantsales.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(val route : String,val title:String,val icon: ImageVector) {
    object Home : BottomBarScreen("home", "Home", Icons.Default.Home)
    object Favorite : BottomBarScreen("favorite", "Favourite", Icons.Default.Favorite)
    object Profile : BottomBarScreen("profile", "Profile", Icons.Default.Person)
}
