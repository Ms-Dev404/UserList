package com.example.user.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.user.databinding.ActivityLoginBinding
import com.example.user.ui.viewmodel.HomeViewModel
import com.example.user.ui.viewmodel.ViewModelFactory
import com.google.gson.Gson


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ViewModelFactory()
        val viewModel = ViewModelProvider(this,factory)[HomeViewModel::class.java]
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val d ="hey"
            val spString = SpannableString(d)
            spString.setSpan(Color.parseColor("#5DA7A3"),d.length,d.length,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
            tvSignUp.text =spString
        }
        viewModel.signIn("shak@gmail.com","123456")
        viewModel.loginResponse.observe(this) {

            Log.e("TAG", "onCreate: "+Gson().toJson(it) )
        }


    }
}