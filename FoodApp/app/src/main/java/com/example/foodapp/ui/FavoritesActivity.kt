package com.example.foodapp.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.adapter.FavoriteAdapter
import com.example.foodapp.database.AppDatabase
import com.example.foodapp.model.FavoriteMeal

class FavoritesActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var adapter: FavoriteAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        database = AppDatabase.getDatabase(this)
        recyclerView = findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadFavorites()

        val buttonBack: Button = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, RecipeListActivity::class.java))
        }
    }

    // Load favorites from the database and update the RecyclerView
    private fun loadFavorites() {
        val favorites = LoadFavoritesTask().execute().get()
        adapter = FavoriteAdapter(favorites) { meal ->
            removeFromFavorites(meal)
        }
        recyclerView.adapter = adapter
    }

    private fun removeFromFavorites(meal: FavoriteMeal) {
        RemoveMealTask(meal).execute()
    }

    private inner class LoadFavoritesTask : AsyncTask<Void, Void, List<FavoriteMeal>>() {
        override fun doInBackground(vararg params: Void?): List<FavoriteMeal> {
            return database.favoriteMealDao().getAllFavorites()
        }
    }

    private inner class RemoveMealTask(val meal: FavoriteMeal) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            database.favoriteMealDao().deleteMeal(meal)
            return null
        }

        override fun onPostExecute(result: Void?) {
            Toast.makeText(applicationContext, "Removed from favorites", Toast.LENGTH_SHORT).show()
            loadFavorites()
        }
    }
}
