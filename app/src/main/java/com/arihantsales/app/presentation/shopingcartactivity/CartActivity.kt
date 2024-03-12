package com.arihantsales.app.presentation.shopingcartactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arihantsales.app.R
import com.arihantsales.app.common.composable.BottomBar
import com.arihantsales.app.common.composable.TopBar
import com.arihantsales.app.presentation.navigation.SetUpNavigation
import com.arihantsales.app.ui.theme.ArihantSalesTheme

class CartActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArihantSalesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar("Shoping Cart") },
                    content = {
                        Box(
                            modifier = Modifier
                                .padding(
                                    5.dp,
                                    it.calculateTopPadding(),
                                    5.dp,
                                    it.calculateBottomPadding()
                                )
                        ) {

                        }
                    }
                )
            }
        }
    }
}