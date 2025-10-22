package com.example.flashcardapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class ScoreActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        this.setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(this.findViewById(R.id.main)) { v , insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }val scoreTextView = this.findViewById(R.id.scoreTextView)
        val finalFeedbackTextView: TextView = this.findViewById(R.id.finalFeedbackTextView)
        val reviewButton: Button = androidx.appcompat.app.AppCompatActivity.findViewById(R.id.reviewButton)

        // Get the score from the Intent
        val score = this.intent.getIntExtra("SCORE", 0)
        val totalQuestions = this.intent.getIntExtra("TOTAL_QUESTIONS", 0)

        scoreTextView.text = "You scored $score out of $totalQuestions"

        // Provide personalized feedback
        if (score == totalQuestions) {
            finalFeedbackTextView.text = "Perfect score! Great job! 🎉"
        } else {
            finalFeedbackTextView.text = "Keep practicing! You'll get there. 👍"
        }

        // The "Review" button logic would be more complex. For now, you can
        // have it do nothing or navigate back to the start.
    }
}
    }
}