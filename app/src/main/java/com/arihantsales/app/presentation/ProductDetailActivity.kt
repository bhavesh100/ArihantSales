package com.arihantsales.app.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arihantsales.app.common.composable.TopBar
import com.arihantsales.app.presentation.navigation.Routes
import com.arihantsales.app.presentation.navigation.SetUpNavigation
import com.arihantsales.app.presentation.screens.ProductDetailScreen
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
                        Box(modifier = Modifier.padding(5.dp,it.calculateTopPadding(),5.dp ,it.calculateBottomPadding())){
                                ProductDetailScreen(thumbnail,name!!,description!!)
                        }
                    }
                )

            }
        }
    }
}