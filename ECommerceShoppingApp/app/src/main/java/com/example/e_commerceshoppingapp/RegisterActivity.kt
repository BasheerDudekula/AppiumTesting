package com.example.e_commerceshoppingapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceshoppingapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConformPassword.text.toString()
            val mobile = binding.etMobile.text.toString()

            if (validateInput(email, password, confirmPassword, mobile)) {
                Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        binding.btnCancel.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun validateInput(email: String, password: String, confirmPassword: String, mobile: String): Boolean {
        return when {
            TextUtils.isEmpty(email) -> {
                binding.etEmail.error = "Email is required"
                false
            }
            TextUtils.isEmpty(password) -> {
                binding.etPassword.error = "Password is required"
                false
            }
            TextUtils.isEmpty(confirmPassword) -> {
                binding.etConformPassword.error = "Confirm Password is required"
                false
            }
            password != confirmPassword -> {
                binding.etConformPassword.error = "Passwords do not match"
                false
            }
            TextUtils.isEmpty(mobile) -> {
                binding.etMobile.error = "Mobile number is required"
                false
            }
            mobile.length != 10 -> {
                binding.etMobile.error = "Enter a valid 10-digit mobile number"
                false
            }
            else -> true
        }
    }
}