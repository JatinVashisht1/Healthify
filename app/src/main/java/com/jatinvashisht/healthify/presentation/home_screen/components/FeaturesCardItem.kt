package com.jatinvashisht.healthify.presentation.home_screen.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.jatinvashisht.healthify.core.Screen
import com.jatinvashisht.healthify.presentation.util.MyPaddings


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeaturesCardItem(modifier: Modifier = Modifier, featuresCardsEntity: FeaturesCardsEntity, navController: NavController, context: Context) {
    Card(modifier = modifier, onClick = {
        when (featuresCardsEntity.title) {
            "BMI" -> {
                navController.navigate(Screen.BmiCalculatorScreen.route){
                    launchSingleTop = true
                }
            }
            "WHO Guidelines" -> {
                navController.navigate(Screen.WhoGuidelinesScreen.route){
                    launchSingleTop = true
                }
            }
            else -> {
                Toast.makeText(context, "Not implemented yet!", Toast.LENGTH_LONG).show()
            }
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(
                        brush = Brush.horizontalGradient(
                            colors = listOf<Color>(
                                Color(165, 214, 167, 255),
                                Color(128, 203, 196, 255),
                            )
                        )
                    )
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = featuresCardsEntity.title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = MyPaddings.Small.padding),
                color = Color(57, 73, 171, 255),
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
            )
            Spacer(modifier = Modifier.height(MyPaddings.Medium.padding))
            Text(
                text = featuresCardsEntity.description,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = MyPaddings.Small.padding),
                textAlign = TextAlign.Center,
                color = Color(57, 73, 171, 255),
//                fontSize = MaterialTheme.typography.titleMedium.fontSize,
            )
        }
    }
}