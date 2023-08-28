package com.arihantsales.app.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arihantsales.app.common.Resource
import com.arihantsales.app.domain.usecase.GetBannerImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BannerImagesViewModel @Inject constructor(
    private val getBannerUseCase: GetBannerImageUseCase
) : ViewModel() {
    private val _state = mutableStateOf(BannerImagesState())
    val state: State<BannerImagesState> = _state

    init {
        getBannerImages()
    }
    private fun getBannerImages(){
        getBannerUseCase().onEach {result->
            when(result){
                is Resource.Success -> {
                    _state.value = BannerImagesState(images = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = BannerImagesState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = BannerImagesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}