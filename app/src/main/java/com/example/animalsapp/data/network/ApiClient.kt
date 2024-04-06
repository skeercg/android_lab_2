package com.example.animalsapp.data.network

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.api-ninjas.com/v1/"
    private const val API_KEY = "cUCBh4Jp3ARuqRqRK83Kgg==OAZClrrwRLtOatGy"

    private val httpClient = OkHttpClient.Builder().apply {
        addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("X-Api-Key", API_KEY)
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }
    }.build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    val animalsApi: AnimalsApi by lazy {
        retrofit.create(AnimalsApi::class.java)
    }
}