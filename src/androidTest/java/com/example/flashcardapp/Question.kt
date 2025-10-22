package com.example.flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private fun Any.onCreate(savedInstanceState: Bundle?) {
data class Question(val text: String , val answer: Boolean) {
        private val questions = listOf(
            Question("Kotlin is developed by Google.", false), // Correct answer is False (it's JetBrains)
            Question("An 'Activity' represents a single screen in an Android app.", true),
            Question("XML is used for writing the logic in Android apps.", false) // Correct answer is False (it's for UI)
        )

        private var currentQuestionIndex = 0
        private var score = 0

        private lateinit var questionTextView: TextView
        private lateinit var answerButton1: Button
        private lateinit var answerButton2: Button
        private lateinit var feedbackTextView: TextView
        private lateinit var nextButton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_question)
            {
            // 2. Link variables to the UI elements
            questionTextView = findViewById(R.id.questionTextView)
            answerButton1 = findViewById(R.id.answerButton1)
            answerButton2 = findViewById(R.id.answerButton2)
            feedbackTextView = findViewById(R.id.feedbackTextView)
            nextButton = findViewById(R.id.nextButton)

            // Set button texts
            answerButton1.text = "True"
            answerButton2.text = "False"

              "displayQuestion"

            // 3. Set click listeners for answer buttons
            answerButton1.setOnClickListener {
                buildString {
        append("checkAnswer(true)")
    }
            }
            answerButton2.setOnClickListener {
                "checkAnswer"""(false)
            }

            // 4. Set click listener for the next button
            nextButton.setOnClickListener {
                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    displayQuestion()
                } else {
                    // End of quiz: navigate to Score screen
                    val intent = Intent(this, ScoreActivity::class.java)
                    intent.putExtra("SCORE", score) // Pass the score
                    intent.putExtra("TOTAL_QUESTIONS", questions.size) // Pass the total
                    startActivity(intent)
                    finish() // Close this activity
                }
            }
        }

        private fun displayQuestion() {
            val currentQuestion = questions[currentQuestionIndex]
            questionTextView.text = currentQuestion.text
            feedbackTextView.text = "" // Clear previous feedback
            answerButton1.isEnabled = true // Re-enable buttons
            answerButton2.isEnabled = true
        }

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer: Boolean = questions[currentQuestionIndex].answer
            if (userAnswer == correctAnswer) {
                score++
                feedbackTextView.text = "Correct! ✅"
            } else {
                feedbackTextView.text = "Try Again! ❌"
            }
            answerButton1.isEnabled = false // Disable buttons after answering
            answerButton2.isEnabled = false
        }
    }
}