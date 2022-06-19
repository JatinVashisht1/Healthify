package com.jatinvashisht.healthify.presentation.bmi_calculator.components

data class BmiCalculatorScreenState(
    val isAdult: Boolean = true,
    val weight: String = "",
    val height: String = "",
    val result: String = "",
    val weightStatus: String = ""
)
