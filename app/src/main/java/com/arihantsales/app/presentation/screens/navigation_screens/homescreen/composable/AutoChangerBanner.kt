package com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoChangerBanner(bannerImages: List<String>){
    Card (
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(16.dp)
    ){
        if(bannerImages.isNotEmpty()){
            AutoSlidingCarousel(
                itemsCount = bannerImages.size, itemContent = { index ->
                    AsyncImage(
                        bannerImages[index],
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(200.dp)
                    )
                }
            )
        }
    }
}