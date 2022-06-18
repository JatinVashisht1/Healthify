package com.jatinvashisht.healthify.data.json_parser

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jatinvashisht.healthify.data.dto.FruitNutrients
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

interface JsonParser{
    fun fromJsonToDataClass(json: ByteArray): FruitNutrients
}