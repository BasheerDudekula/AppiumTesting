package com.example.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.fitnesstracker.adapter.OnboardingAdapter
import com.example.fitnesstracker.model.OnboardingItem
import com.google.android.material.button.MaterialButton

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val btnSkip = findViewById<Button>(R.id.btnSkip)

        val slides = listOf(
            OnboardingItem("Stay Active!", "Exercise daily for a healthy life."),
            OnboardingItem("Track Progress", "Monitor your fitness metrics."),
            OnboardingItem("Stay Hydrated", "Drink enough water every day.")
        )

        viewPager.adapter = OnboardingAdapter(slides)

        btnSkip.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == slides.size - 1) {
                    startActivity(Intent(this@OnboardingActivity, DashboardActivity::class.java))
                    finish()
                }
            }
        })
    }
}