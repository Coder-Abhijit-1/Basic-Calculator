package com.example.android.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link the UI components
        val firstNumField: EditText = findViewById(R.id.firstNum)
        val secondNumField: EditText = findViewById(R.id.secondNum)
        val resultView: TextView = findViewById(R.id.res)
        val addButton: Button = findViewById(R.id.addBtn)
        val subButton: Button = findViewById(R.id.subBtn)
        val multiButton: Button = findViewById(R.id.multiBtn)
        val divButton: Button = findViewById(R.id.divBtn)
        val resetButton: Button = findViewById(R.id.reset)

        // Function to fetch inputs and validate them
        fun getValidatedInputs(): Pair<Double, Double>? {
            val firstNum = firstNumField.text.toString().toDoubleOrNull()
            val secondNum = secondNumField.text.toString().toDoubleOrNull()
            return if (firstNum != null && secondNum != null) {
                Pair(firstNum, secondNum)
            } else {
                resultView.text = "Invalid Input"
                null
            }
        }

        // Set OnClickListener for addition
        addButton.setOnClickListener {
            val inputs = getValidatedInputs()
            inputs?.let {
                val result = it.first + it.second
                resultView.text = result.toString()
            }
        }

        // Set OnClickListener for subtraction
        subButton.setOnClickListener {
            val inputs = getValidatedInputs()
            inputs?.let {
                val result = it.first - it.second
                resultView.text = result.toString()
            }
        }

        // Set OnClickListener for multiplication
        multiButton.setOnClickListener {
            val inputs = getValidatedInputs()
            inputs?.let {
                val result = it.first * it.second
                resultView.text = result.toString()
            }
        }

        // Set OnClickListener for division
        divButton.setOnClickListener {
            val inputs = getValidatedInputs()
            inputs?.let {
                if (it.second == 0.0) {
                    resultView.text = "Cannot Divide by Zero"
                } else {
                    val result = it.first / it.second
                    resultView.text = result.toString()
                }
            }
        }

        // Set OnClickListener for reset
        resetButton.setOnClickListener {
            firstNumField.text.clear()
            secondNumField.text.clear()
            resultView.text = ""
        }
    }
}
