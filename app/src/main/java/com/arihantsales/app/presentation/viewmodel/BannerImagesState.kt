package com.arihantsales.app.presentation.viewmodel

import com.arihantsales.app.domain.model.Product

data class BannerImagesState(
    val isLoading: Boolean = false,
    val images: List<String> = emptyList(),
    val error: String = ""
)
