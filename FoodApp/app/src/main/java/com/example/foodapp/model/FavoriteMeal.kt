package com.example.foodapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_meals")
data class FavoriteMeal(
    @PrimaryKey val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String
)

