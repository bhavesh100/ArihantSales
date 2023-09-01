package com.arihantsales.app.presentation.screens.navigation_screens.homescreen.banner


data class BannerImagesState(
    val isLoading: Boolean = false,
    val images: List<String> = emptyList(),
    val error: String = ""
)
