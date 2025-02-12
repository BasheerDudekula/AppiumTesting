package com.example.foodapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.foodapp.model.FavoriteMeal

@Dao
interface FavoriteMealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(meal: FavoriteMeal)

    @Delete
    fun deleteMeal(meal: FavoriteMeal)

    @Query("SELECT * FROM favorite_meals")
    fun getAllFavorites(): List<FavoriteMeal>
}
