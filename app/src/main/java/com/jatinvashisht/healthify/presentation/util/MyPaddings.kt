package com.jatinvashisht.healthify.presentation.util

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class MyPaddings(val padding: Dp) {
    object VerySmall: MyPaddings(padding = 4.dp)
    object Small: MyPaddings(padding = 8.dp)
    object Medium: MyPaddings(padding = 16.dp)
    object Large: MyPaddings(padding = 32.dp)
}