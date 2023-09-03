package com.arihantsales.app.presentation.shopingcartactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.arihantsales.app.ui.theme.ArihantSalesTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArihantSalesTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "cart screen")
                }
            }
        }
    }
}