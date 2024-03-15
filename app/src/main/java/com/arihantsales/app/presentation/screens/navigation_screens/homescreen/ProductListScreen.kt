package com.arihantsales.app.presentation.screens.navigation_screens.homescreen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.arihantsales.app.R
import com.arihantsales.app.domain.model.Product
import com.arihantsales.app.presentation.productdetailactivity.ProductDetailActivity
import com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable.ProductListItem
import com.arihantsales.app.presentation.navigation.Routes
import com.arihantsales.app.presentation.screens.navigation_screens.homescreen.banner.BannerImagesViewModel
import com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable.AutoChangerBanner

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
    val categoriesList = listOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5

    )
    LazyColumn {
        item{
            AutoChangerBanner(bannerImages)
        }
        item {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
        Categories(categoriesList)
        item {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Products",
                fontWeight = FontWeight.Bold
            )
        }
        ProductList(productList, context)
    }
}
fun LazyListScope.Categories(categoriesList: List<Int>) {
    item {
        LazyRow{
            categoriesList.forEach{ch->
                item {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .shadow(elevation = 3.dp, shape = CircleShape)
                    ) {
                        AsyncImage(model = ch, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.size(5.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.ProductList(productList:List<Product>, context: Context){
    item{
        FlowRow {
            productList.forEach{
                ProductListItem(product = it){ product ->
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