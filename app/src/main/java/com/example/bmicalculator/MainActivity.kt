package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var ageInput: EditText
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageInput = findViewById(R.id.ageInput)
        weightInput = findViewById(R.id.weightInput)
        heightInput = findViewById(R.id.heightInput)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val age = ageInput.text.toString().toInt()
            val weight = weightInput.text.toString().toDouble()
            val height = heightInput.text.toString().toDouble()
            val bmi = calculateBMI(weight, height)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("bmi", bmi)
            startActivity(intent)
        }
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        val heightInMeters = height / 100
        return weight / (heightInMeters * heightInMeters)
    }
}
