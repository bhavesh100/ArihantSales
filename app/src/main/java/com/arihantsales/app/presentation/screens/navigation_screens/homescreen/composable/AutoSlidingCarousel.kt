package com.arihantsales.app.presentation.screens.navigation_screens.homescreen.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = 1000,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit
){
//    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    LaunchedEffect(pagerState.currentPage){
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
    }
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalPager(pageCount = itemsCount, state = pagerState){page->
            itemContent(page)
        }
    }
}