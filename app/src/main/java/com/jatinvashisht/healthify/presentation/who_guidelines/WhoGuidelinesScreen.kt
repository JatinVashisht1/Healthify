package com.jatinvashisht.healthify.presentation.who_guidelines

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jatinvashisht.healthify.presentation.util.MyPaddings
import com.jatinvashisht.healthify.presentation.who_guidelines.components.WhoGuidelinesEntity

@Composable
fun WhoGuidelinesScreen(
    whoGuidelinesViewModel: WhoGuidelinesViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState, modifier = Modifier.fillMaxSize().drawBehind {
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
            SmallTopAppBar(
                title = { Text(text = "WHO Guidelines to stay healthy") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "move back"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(
                        1,
                        87,
                        155,
                        255
                    )
                )
            )
        }
        items(whoGuidelinesViewModel.whoGuidelinesEntityList) { item ->
            WhoGuidelinesEntityListItem(
                whoGuidelinesEntity = item,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MyPaddings.Medium.padding)
                    .animateContentSize(tween(300))
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhoGuidelinesEntityListItem(
    modifier: Modifier = Modifier,
    whoGuidelinesEntity: WhoGuidelinesEntity
) {
    val showDescription = rememberSaveable { mutableStateOf(false) }
    Card(modifier = modifier, onClick = { showDescription.value = !showDescription.value }) {
        Column(modifier = Modifier
            .fillMaxSize()
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
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MyPaddings.Small.padding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = whoGuidelinesEntity.title,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth(0.9f),
                    color = Color(57, 73, 171, 255),
                )
                Spacer(modifier = Modifier.width(MyPaddings.Small.padding))
                IconButton(onClick = { showDescription.value = !showDescription.value }) {
                    Icon(
                        imageVector = if (showDescription.value) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null,
                        tint = Color(57, 73, 171, 255)
                    )
                }
            }

            if (showDescription.value) {
                Text(
                    text = whoGuidelinesEntity.description,
                    modifier = Modifier.padding(horizontal = MyPaddings.Small.padding),
                    color = Color(57, 73, 171, 255),
                )
            }
        }
    }
}