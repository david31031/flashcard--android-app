package com.example.flashcardapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v , insets ->
        }

        val startButton: Button = findViewById(R.id.startButton)
           startButton.setOnClickListener {
               // Create an Intent to start QuestionActivity
               val intent = Intent(this, QuestionActivity::class.java)
               startActivity(intent)
       }
    }
}