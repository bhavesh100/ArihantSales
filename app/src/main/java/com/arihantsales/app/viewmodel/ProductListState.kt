package com.arihantsales.app.viewmodel

import com.arihantsales.app.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
