package com.arihantsales.app.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.arihantsales.app.R
import com.arihantsales.app.common.composable.BottomBar
import com.arihantsales.app.common.composable.TopBar
import com.arihantsales.app.presentation.navigation.SetUpNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(){
    val navController = rememberNavController()
    androidx.compose.material3.Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(stringResource(R.string.app_name)) },
        bottomBar = { BottomBar(navController) },
        content = {
            Box(modifier = Modifier.padding(5.dp,it.calculateTopPadding(),5.dp ,it.calculateBottomPadding())){
                SetUpNavigation(navController)
            }

        }
    )
}