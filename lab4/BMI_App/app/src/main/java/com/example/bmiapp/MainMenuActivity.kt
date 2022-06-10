package com.example.bmiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val btnOpenCalculator = findViewById<Button>(R.id.btnOpenCalculator)
        val btnOpenKcalCalculator = findViewById<Button>(R.id.btnOpenKcalCalculator)
        val btnOpenQuizActivity = findViewById<Button>(R.id.btnOpenQuizActivity)
        val btnQuitApp = findViewById<Button>(R.id.btnQuitApp)

        btnOpenCalculator.setOnClickListener{
            val calculatorActivity  = Intent(this, BMICalculatorActivity::class.java)
            startActivity(calculatorActivity)
        }

        btnOpenKcalCalculator.setOnClickListener{
            val kcalCalculatorActivity = Intent(this, KCalsCalculatorActivity::class.java)
            startActivity(kcalCalculatorActivity)
        }

        btnOpenQuizActivity.setOnClickListener{
            val quizActivity = Intent(this, QuizActivity::class.java)
            startActivity(quizActivity)
        }

        btnQuitApp.setOnClickListener {
            finish()
        }
    }
}