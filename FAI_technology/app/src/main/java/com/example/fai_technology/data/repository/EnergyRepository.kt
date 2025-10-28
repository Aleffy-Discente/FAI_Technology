package com.example.fai_technology.data.repository

import com.example.fai_technology.data.model.DogImage
import com.example.fai_technology.data.network.EnergyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EnergyRepository {

    private val api: EnergyApiService by lazy {
        Retrofit.Builder()
            .baseUrl(EnergyApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EnergyApiService::class.java)
    }

    suspend fun fetchRandomDogImage(): DogImage? {
        val response = api.getRandomDogImage()
        return if (response.isSuccessful) response.body() else null
    }
}