package com.example.e_commerceshoppingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceshoppingapp.databinding.ActivityProductListingBinding

class ProductListingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListingBinding
    private val selectedProduct = mutableListOf<Product>() // Store selected products

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = listOf(
            Product("Laptop", 800.0),
            Product("Smartphone", 600.0),
            Product("Headphones", 150.0)
        )

        displayProducts(products)
    }

    private fun displayProducts(products: List<Product>) {
        val layout = binding.productContainer // Parent LinearLayout in XML

        for (product in products) {
            val productTextView = TextView(this).apply {
                text = "${product.name} - $${product.price}"
                textSize = 18f
                setPadding(16, 16, 16, 8)
            }

            val buyButton = Button(this).apply {
                text = "Add to Cart"
                setOnClickListener {
                    selectedProduct.add(product)
                    Toast.makeText(this@ProductListingActivity, "${product.name} added to cart!", Toast.LENGTH_SHORT).show()
                }
            }

            // Add TextView and Button to LinearLayout
            layout.addView(productTextView)
            layout.addView(buyButton)
        }

        // Checkout Button
        val checkoutButton = Button(this).apply {
            text = "Go to Checkout"
            setOnClickListener {
                val intent = Intent(this@ProductListingActivity, CheckoutActivity::class.java)
                intent.putExtra("selected_product_name", selectedProduct.joinToString { it.name })
                intent.putExtra("selected_product_price", selectedProduct.sumOf { it.price })
                startActivity(intent)
            }
        }
        layout.addView(checkoutButton)
        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}