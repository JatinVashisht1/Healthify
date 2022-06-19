package com.jatinvashisht.healthify.presentation.home_screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jatinvashisht.healthify.presentation.home_screen.components.FeaturesCardItem
import com.jatinvashisht.healthify.presentation.home_screen.components.FeaturesCardsEntity
import com.jatinvashisht.healthify.presentation.util.MyPaddings
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val featuresCardList = homeScreenViewModel.lazyRowCardsItemList
    val lazyRowState = rememberLazyListState()
    val randomFruit by homeScreenViewModel.fruitNutrientsItemModelState
    LaunchedEffect(key1 = Unit) {
        for (i in 0 until 3) {
            lazyRowState.animateScrollToItem(i)
            delay(1000)
        }
        lazyRowState.animateScrollToItem(0)
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .drawBehind {
            drawRect(
                brush = Brush.verticalGradient(
                    listOf<Color>(
//                        Color(100, 181, 246, 255),
//                        Color(121, 134, 203, 255),
                        Color(1, 87, 155, 255),
                        Color(13, 71, 161, 255),
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
                            .shadow(elevation = MyPaddings.Medium.padding),
                        navController = navController
                    )
                }
            }
            Spacer(modifier = Modifier.height(MyPaddings.Medium.padding))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = MyPaddings.Medium.padding)

            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .drawBehind {
                        drawRect(
                            brush = Brush.horizontalGradient(
                                listOf<Color>(
                                    Color(165, 214, 167, 255),
                                    Color(128, 203, 196, 255),
                                )
                            )
                        )
                    }
                    .padding(MyPaddings.Medium.padding)
                ) {
                    Spacer(modifier = Modifier.height(MyPaddings.Small.padding))
                    CustomTextView("Name: ", randomFruit.name)
                    Spacer(modifier = Modifier.height(MyPaddings.Small.padding))
                    CustomTextView("Genus: ", randomFruit.genus)
                    Spacer(modifier = Modifier.height(MyPaddings.Small.padding))
                    CustomTextView("Family: ", randomFruit.family)
                    Spacer(modifier = Modifier.height(MyPaddings.Small.padding))
                    CustomTextView("Order: ", randomFruit.order)
                    Spacer(modifier = Modifier.height(MyPaddings.Small.padding))
                    CustomTextView("Nutrients: ", "${randomFruit.nutritions}")
                    Spacer(modifier = Modifier.height(MyPaddings.Small.padding))
                }
            }
            Spacer(modifier = Modifier.height(MyPaddings.Medium.padding))
            Button(
                onClick = homeScreenViewModel::onGetRandomFruitInfoButtonClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyPaddings.Medium.padding),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(255, 241, 118, 255),
                    contentColor = Color(57, 73, 171, 255),
                ),
            ) {
                Text(text = "Get Random Fruit Info")
            }
        }
    }
}

@Composable
fun CustomTextView(first: String, second: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = first, fontWeight = FontWeight.Bold, color = Color(57, 73, 171, 255))
        Text(text = second, fontWeight = FontWeight.Normal, color = Color(57, 73, 171, 255))
    }
}
