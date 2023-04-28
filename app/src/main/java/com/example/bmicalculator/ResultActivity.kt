package com.example.bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.os.Bundle
import android.content.Intent


class ResultActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var backButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultText = findViewById(R.id.resultText)
        backButton = findViewById(R.id.backButton)

        val bmi = intent.getDoubleExtra("bmi", 0.0)

        val bmiCategory = when {
            bmi < 18.5 -> "Underweight"
            bmi < 25 -> "Normal"
            bmi < 30 -> "Overweight"
            else -> "Obese"
        }

        resultText.text = bmi.toString()

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
