package com.arihantsales.app.presentation.screens.navigation_screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arihantsales.app.composable.ProductListItem
import com.arihantsales.app.viewmodel.ProductListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val productList = state.products
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(150.dp),
        modifier = Modifier.padding(start = 5.dp, end = 5.dp),
        verticalItemSpacing = 5.dp,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
        items(productList){product->
            ProductListItem(product){

            }
        }
    }
}