package com.example.fitnesstracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val txtMetrics = findViewById<TextView>(R.id.txtMetrics)
        val btnSyncDevice = findViewById<Button>(R.id.btnSync)

        btnSyncDevice.setOnClickListener {
            txtMetrics.text = "Steps: 5000 | Calories: 300"
            Toast.makeText(this, "Data Synced Successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
