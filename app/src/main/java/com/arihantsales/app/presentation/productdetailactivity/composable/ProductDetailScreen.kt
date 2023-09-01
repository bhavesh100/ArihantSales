package com.arihantsales.app.presentation.productdetailactivity.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductDetailScreen(thumbnail: String?,name: String,description: String){
    val scrollableState = rememberScrollState(0)
    Column(modifier = Modifier.verticalScroll(scrollableState)
        .padding(5.dp)) {
        AsyncImage(
            model = thumbnail,contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "description",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = " Price 100$",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedButton(
            onClick = {},
            Modifier.fillMaxWidth(0.5f)
                .align(Alignment.CenterHorizontally),
        ){
            Text(text = "Buy Now", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
//    ProductDetailScreen()
}