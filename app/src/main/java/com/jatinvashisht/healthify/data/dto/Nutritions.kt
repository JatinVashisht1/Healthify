package com.jatinvashisht.healthify.data.dto

data class Nutritions(
    val calories: Double = 0.0,
    val carbohydrates: Double = 0.0,
    val fat: Double = 0.0,
    val protein: Double = 0.0,
    val sugar: Double = 0.0,
){
    override fun toString(): String {
        return "calories: $calories, carbohydrates: $carbohydrates, fat: $fat, protein: $protein, sugar: $sugar"
    }
}