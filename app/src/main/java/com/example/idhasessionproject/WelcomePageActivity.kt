package com.example.idhasessionproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val continueButton = findViewById<Button>(R.id.continue_button)
        continueButton.setOnClickListener {
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }
}
