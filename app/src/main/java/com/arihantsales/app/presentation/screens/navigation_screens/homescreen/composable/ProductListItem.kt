package com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.arihantsales.app.domain.model.Product

@Composable
fun ProductListItem(product: Product, onItemClick: (Product) -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(10.dp)
            .clickable {
                onItemClick(product)
            }
    ) {
        Card(modifier = Modifier
            .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(2.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            AsyncImage(model = product.thumbnail,contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .aspectRatio(1f)
            )
        }
        Text(
            text = product.name,
            fontWeight = FontWeight.Light,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "100$",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreiew(){
    ProductListItem(
        Product(
            "ubebfhr",
            "Product name",
            "example.jpg",
            "de"
        )
    ){

    }
}