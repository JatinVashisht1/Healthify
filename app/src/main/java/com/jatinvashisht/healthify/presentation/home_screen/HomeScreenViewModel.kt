package com.jatinvashisht.healthify.presentation.home_screen

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatinvashisht.healthify.data.dto.toFruitNutrientsModel
import com.jatinvashisht.healthify.data.json_parser.JsonParser
import com.jatinvashisht.healthify.domain.model.FruitNutrientsItemModel
import com.jatinvashisht.healthify.domain.model.FruitNutrientsModel
import com.jatinvashisht.healthify.presentation.home_screen.components.FeaturesCardsEntity
import kotlinx.coroutines.launch

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val jsonParser: JsonParser,
    private val myApplication: Application
) : ViewModel() {
    private val lazyRowCardsItemListState = mutableStateListOf<FeaturesCardsEntity>(
        FeaturesCardsEntity(title = "BMI", description = "Calculate BMI"),
        FeaturesCardsEntity(
            title = "WHO Guidelines",
            description = "WHO guidelines to live healthy life"
        ),
        FeaturesCardsEntity(
            title = "Timetable",
            description = "Timetable designed to keep you healthy"
        )
    )
    val lazyRowCardsItemList = lazyRowCardsItemListState

    var fruitNutrientsItemModelState = mutableStateOf<FruitNutrientsItemModel>(
        FruitNutrientsItemModel()
    )

    init {
        viewModelScope.launch {
            fruitNutrientsItemModelState.value = getRandomFruitNutrients()
        }
    }

    fun onGetRandomFruitInfoButtonClicked() {
        viewModelScope.launch {
            fruitNutrientsItemModelState.value = getRandomFruitNutrients()
        }
    }

    private fun getRandomFruitNutrients(): FruitNutrientsItemModel {
        val jsonData = myApplication.assets.open("FruitsNutrientsJsonFile.json")
            .readBytes()
        return jsonParser.fromJsonToDataClass(json = jsonData)
            .toFruitNutrientsModel().fruitNutrientsItemModelList.random()
    }
}