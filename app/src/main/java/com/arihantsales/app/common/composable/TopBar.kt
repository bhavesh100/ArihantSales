package com.arihantsales.app.common.composable


import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.arihantsales.app.presentation.navigation.BottomBarScreen
import com.arihantsales.app.presentation.shopingcartactivity.CartActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        actions = {
            IconButton(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.surface, shape = CircleShape)
                    .size(40.dp)
                    .border(BorderStroke(3.dp,MaterialTheme.colorScheme.outlineVariant), shape = CircleShape),
                onClick = {
                    val intent = Intent(context,CartActivity::class.java)
                    context.startActivity(intent)
                },
            ){
                Icon(
                    imageVector = BottomBarScreen.Cart.icon,
                    contentDescription = null
                )
            }
        }
    )
}
