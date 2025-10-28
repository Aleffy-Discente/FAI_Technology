package com.example.fai_technology.data.network

import com.example.fai_technology.data.model.DogImage
import retrofit2.Response
import retrofit2.http.GET

interface EnergyApiService {

    // Endpoint que retorna uma imagem aleatória de cachorro
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): Response<DogImage>

    companion object {
        const val BASE_URL = "https://dog.ceo/api/"
    }
}
