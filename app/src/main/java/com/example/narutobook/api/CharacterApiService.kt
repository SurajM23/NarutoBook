package com.example.narutobook.api

import com.example.narutobook.model.CharacterResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CharacterApiService {
    @GET("characters")
    suspend fun getCharacters(): Response<CharacterResponse>
}

object RetrofitInstance {
    private const val BASE_URL = "https://dattebayo-api.onrender.com/"

    val api: CharacterApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterApiService::class.java)
    }
}
