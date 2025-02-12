package com.example.e_commerceshoppingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceshoppingapp.databinding.ActivityCheckoutBinding

class CheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productNames = intent.getStringExtra("selected_product_name") ?: "No Items"
        val totalPrice = intent.getDoubleExtra("selected_product_price", 0.0)

        binding.tvProductList.text = "Selected Products: $productNames"
        binding.tvTotalPrice.text = "Total Price: $$totalPrice"

        binding.buttonPay.setOnClickListener {
            Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ProductListingActivity::class.java))
        }
        binding.buttonCancel.setOnClickListener {
            startActivity(Intent(this, ProductListingActivity::class.java))
        }
    }
}