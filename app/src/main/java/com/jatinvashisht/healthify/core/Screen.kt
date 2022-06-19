package com.jatinvashisht.healthify.core

sealed class Screen(val route: String){
    object HomeScreen: Screen("homescreen")
    object BmiCalculatorScreen: Screen("bmicalculatorscreen")
    object WhoGuidelinesScreen: Screen("whoguidelinesscreen")
}
