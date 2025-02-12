package com.example.foodapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class MealResponse(val meals: List<Meal>)

@Parcelize
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strInstructions: String
):Parcelable

