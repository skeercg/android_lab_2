package com.example.animalsapp.data.network

import com.example.animalsapp.data.model.Animal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimalsApi {
    @GET("animals")
    fun getAnimals(@Query("name") name: String): Call<List<Animal>>
}