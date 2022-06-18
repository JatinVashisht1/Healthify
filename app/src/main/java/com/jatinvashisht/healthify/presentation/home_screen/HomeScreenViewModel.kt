package com.jatinvashisht.healthify.presentation.home_screen

import androidx.compose.runtime.mutableStateListOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatinvashisht.healthify.presentation.home_screen.components.FeaturesCardsEntity

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel(){
    private val lazyRowCardsItemListState = mutableStateListOf<FeaturesCardsEntity>(
        FeaturesCardsEntity(title = "BMI", description = "Calculate BMI"),
        FeaturesCardsEntity(title = "WHO Guidelines", description = "WHO guidelines to live healthy life"),
        FeaturesCardsEntity(title = "Timetable", description = "Timetable designed to keep you healthy")
    )
    val lazyRowCardsItemList = lazyRowCardsItemListState

    init {

    }
}