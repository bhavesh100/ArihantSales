package com.arihantsales.app.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arihantsales.app.common.Resource
import com.arihantsales.app.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> = _state
    init {
        getProducts()
    }
    private fun getProducts(){
        getProductsUseCase().onEach {result->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductListState(products = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ProductListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = ProductListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}