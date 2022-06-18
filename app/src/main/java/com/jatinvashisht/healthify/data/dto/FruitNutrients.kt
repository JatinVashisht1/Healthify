package com.jatinvashisht.healthify.data.dto

import com.jatinvashisht.healthify.domain.model.FruitNutrientsItemModel
import com.jatinvashisht.healthify.domain.model.FruitNutrientsModel

class FruitNutrients : ArrayList<FruitNutrientsItem>()

fun FruitNutrients.toFruitNutrientsModel(): FruitNutrientsModel {
    val fruitNutrientsModel = mutableListOf<FruitNutrientsItemModel>()
    this.forEach {
        fruitNutrientsModel.add(it.toFruitNutrientsItemModel())
    }
    return FruitNutrientsModel(fruitNutrientsModel)
}