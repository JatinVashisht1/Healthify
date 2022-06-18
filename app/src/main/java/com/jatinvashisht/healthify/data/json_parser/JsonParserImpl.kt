package com.jatinvashisht.healthify.data.json_parser

import android.app.Application
import com.google.gson.Gson
import com.jatinvashisht.healthify.data.dto.FruitNutrients
import javax.inject.Inject

class JsonParserImpl @Inject constructor() : JsonParser {

    override fun fromJsonToDataClass(jsonData: ByteArray): FruitNutrients {
        val jsonString = String(jsonData)
        return Gson()
            .fromJson(jsonString, FruitNutrients::class.java)
    }

}