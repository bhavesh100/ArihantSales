package com.arihantsales.app.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arihantsales.app.domain.model.Product

@Composable
fun ProductListItem(product: Product, onItemClick: (Product) -> Unit){
    Box(modifier = Modifier
        .clickable {
            onItemClick(product)
        }
        .background(color = MaterialTheme.colorScheme.inversePrimary)) {
        Column(modifier = Modifier
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Card(modifier = Modifier.height(200.dp)
                .width(150.dp)
                .padding(0.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                border = BorderStroke(2.dp, Color.Black)
            )
            {

            }
            Text(text = product.name, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            Text(text = "100$")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun itemPreiew(){
    ProductListItem(
        Product(
            "jkhkjdfakjdf",
            "Product Name",
            "example.jpg",
            "description"
    )
    ){

    }
}