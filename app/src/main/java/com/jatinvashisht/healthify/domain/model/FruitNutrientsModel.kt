package com.jatinvashisht.healthify.domain.model

import com.jatinvashisht.healthify.data.dto.Nutritions

data class FruitNutrientsModel(val fruitNutrientsItemModelList: List<FruitNutrientsItemModel>)

data class FruitNutrientsItemModel(
    val family: String = "",
    val genus: String = "",
    val name: String = "",
    val nutritions: Nutritions = Nutritions(),
    val order: String = ""
)

