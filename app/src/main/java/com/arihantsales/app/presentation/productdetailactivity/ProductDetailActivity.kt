package com.arihantsales.app.presentation.productdetailactivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arihantsales.app.common.composable.TopBar
import com.arihantsales.app.presentation.navigation.Routes
import com.arihantsales.app.presentation.productdetailactivity.composable.ProductDetailScreen
import com.arihantsales.app.ui.theme.ArihantSalesTheme

class ProductDetailActivity: ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val thumbnail = intent.getStringExtra(Routes.ProductDetail.route+"/thumbnail")
            val name = intent.getStringExtra(Routes.ProductDetail.route+"/name")
            val description = intent.getStringExtra(Routes.ProductDetail.route+"/description")
            ArihantSalesTheme {
                Scaffold(
                    topBar = {
                        TopBar("Arihant sales")
                    }, content = {
                        Box(
                            modifier = Modifier
                                .padding(
                                    5.dp,it.calculateTopPadding(),
                                    5.dp,
                                    it.calculateBottomPadding()
                                )
                        ){
                                ProductDetailScreen(
                                    thumbnail,
                                    name!!,
                                    description!!
                                )
                        }
                    }
                )
            }
        }
    }
}