package com.jatinvashisht.healthify.presentation.home_screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jatinvashisht.healthify.presentation.home_screen.components.FeaturesCardItem
import com.jatinvashisht.healthify.presentation.home_screen.components.FeaturesCardsEntity
import com.jatinvashisht.healthify.presentation.util.MyPaddings
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {
    val featuresCardList = homeScreenViewModel.lazyRowCardsItemList
    val lazyRowState = rememberLazyListState()

    LaunchedEffect(key1 = Unit) {
        for (i in 0 until 3) {
            lazyRowState.animateScrollToItem(i)
            delay(2000)
        }
        lazyRowState.animateScrollToItem(0)
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .drawBehind {
            drawRect(
                brush = Brush.verticalGradient(
                    listOf<Color>(
                        Color(100, 181, 246, 255),
                        Color(121, 134, 203, 255),
                    )
                )
            )
        }) {
        item {
            Spacer(modifier = Modifier.height(MyPaddings.Medium.padding))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyPaddings.Medium.padding),
                state = lazyRowState
            ) {
                items(featuresCardList) { item: FeaturesCardsEntity ->
                    FeaturesCardItem(
                        featuresCardsEntity = item,
                        modifier = Modifier
                            .height(200.dp)
                            .width(350.dp)
                            .padding(MyPaddings.Medium.padding)
                            .shadow(elevation = MyPaddings.Medium.padding)
                    )
                }
            }
        }
    }
}
