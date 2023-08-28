package com.arihantsales.app.presentation.screens.navigation_screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.arihantsales.app.presentation.composable.AutoSlidingCarousel
import com.arihantsales.app.presentation.composable.ProductListItem
import com.arihantsales.app.presentation.navigation.Routes
import com.arihantsales.app.presentation.screens.ProductDetailScreen
import com.arihantsales.app.presentation.screens.ProductListScreen
import com.arihantsales.app.presentation.viewmodel.BannerImagesViewModel
import com.arihantsales.app.presentation.viewmodel.ProductListViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
//    navController: NavController,
//    viewModel: ProductListViewModel = hiltViewModel(),
//    viewModel2: BannerImagesViewModel = hiltViewModel()
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.ProductList.route
    ){
        composable(route = Routes.ProductList.route){
            ProductListScreen(navController)
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoChangerBanner(bannerImages: List<String>){
    Card (
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(16.dp)
    ){
        if(bannerImages.isNotEmpty()){
            AutoSlidingCarousel(itemsCount = bannerImages.size, itemContent = { index ->
                    AsyncImage(
                        bannerImages[index],
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(200.dp)
                    )
            })
        }

    }
}