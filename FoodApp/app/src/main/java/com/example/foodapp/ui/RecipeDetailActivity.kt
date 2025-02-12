package com.example.foodapp.ui

import android.content.Intent
import com.example.foodapp.R
import com.example.foodapp.database.FavoriteMealDao
import com.example.foodapp.model.FavoriteMeal
import com.example.foodapp.model.Meal

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.foodapp.database.AppDatabase

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var favoriteMealDao: FavoriteMealDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val meal = intent.getParcelableExtra<Meal>("meal")

        val mealName: TextView = findViewById(R.id.mealName)
        val mealImage: ImageView = findViewById(R.id.mealImage)
        val mealInstructions: TextView = findViewById(R.id.mealInstructions)
        val btnFavorite: Button = findViewById(R.id.btnFavorite)

        database = AppDatabase.getDatabase(this)
        favoriteMealDao = database.favoriteMealDao()

        meal?.let {
            mealName.text = it.strMeal
            mealInstructions.text = it.strInstructions
            Glide.with(this).load(it.strMealThumb).into(mealImage)
        }

        btnFavorite.setOnClickListener {
            meal?.let { saveToFavorites(it) }
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        }

        val buttonBack: Button = findViewById(R.id.btnBack)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, RecipeListActivity::class.java))
        }
    }

    // Save to favorites using AsyncTask
    private fun saveToFavorites(meal: Meal) {
        val favoriteMeal = FavoriteMeal(meal.idMeal, meal.strMeal, meal.strMealThumb, meal.strInstructions)
        SaveMealTask(favoriteMeal).execute()
    }

    private inner class SaveMealTask(val meal: FavoriteMeal) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            favoriteMealDao.insertMeal(meal)
            return null
        }
    }
}
