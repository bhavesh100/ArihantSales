package com.arihantsales.app.presentation.screens.navigation_screens.homescreen

import android.content.Intent
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arihantsales.app.presentation.productdetailactivity.ProductDetailActivity
import com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable.ProductListItem
import com.arihantsales.app.presentation.navigation.Routes
import com.arihantsales.app.presentation.screens.navigation_screens.homescreen.banner.BannerImagesViewModel
import com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable.AutoChangerBanner

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel(),
    viewModel2: BannerImagesViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val state = viewModel.state.value
    val productList = state.products
    val bannerState = viewModel2.state.value
    val bannerImages = bannerState.images
    LazyColumn {
        item{
            AutoChangerBanner(bannerImages)
        }
        item{
            FlowRow {
                productList.forEach{
                    ProductListItem(product = it){product->
                        val intent = Intent(context, ProductDetailActivity::class.java)
                        intent.putExtra(Routes.ProductDetail.route+"/thumbnail",product.thumbnail)
                        intent.putExtra(Routes.ProductDetail.route+"/name",product.name)
                        intent.putExtra(Routes.ProductDetail.route+"/description",product.description)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}