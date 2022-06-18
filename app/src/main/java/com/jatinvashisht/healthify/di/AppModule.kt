package com.jatinvashisht.healthify.di

import android.app.Application
import com.jatinvashisht.healthify.HealthifyApplication
import com.jatinvashisht.healthify.data.json_parser.JsonParser
import com.jatinvashisht.healthify.data.json_parser.JsonParserImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesJsonParser(): JsonParser = JsonParserImpl()
}