package com.jatinvashisht.healthify.data.dto

import com.jatinvashisht.healthify.domain.model.FruitNutrientsItemModel

data class FruitNutrientsItem(
    val family: String,
    val genus: String,
    val id: Double,
    val name: String,
    val nutritions: Nutritions,
    val order: String
)

fun FruitNutrientsItem.toFruitNutrientsItemModel(): FruitNutrientsItemModel{
    return FruitNutrientsItemModel(family, genus, name, nutritions, order)
}