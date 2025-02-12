package com.example.foodapp.api

import com.example.foodapp.model.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
    fun searchMeals(@Query("s") query: String): Call<MealResponse>
}