package com.example.foodapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.adapter.RecipeAdapter
import com.example.foodapp.model.MealResponse
import com.example.foodapp.model.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        RetrofitInstance.api.searchMeals("cake").enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                response.body()?.let {
                    adapter = RecipeAdapter(it.meals) { meal ->
                        val intent = Intent(this@RecipeListActivity, RecipeDetailActivity::class.java)
                        intent.putExtra("meal", meal)
                        startActivity(intent)
                    }
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Log.e("API_ERROR", t.message.toString())
            }
        })
        val buttonBack: Button = findViewById(R.id.buttonFavorites)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }
    }
}