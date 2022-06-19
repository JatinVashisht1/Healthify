package com.jatinvashisht.healthify.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jatinvashisht.healthify.presentation.bmi_calculator.BmiCalculator
import com.jatinvashisht.healthify.presentation.home_screen.HomeScreen
import com.jatinvashisht.healthify.presentation.theme.HealthifyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthifyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
//                    HomeScreen()
                    BmiCalculator(navController = navController)
                }
            }
        }
    }
}

