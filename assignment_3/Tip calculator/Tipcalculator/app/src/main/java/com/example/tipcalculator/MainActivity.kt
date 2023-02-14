package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipCalculator.setOnClickListener{calculateTip()}
    }
    private fun calculateTip() {
        val stringInTextField = binding.billInput.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipDefaultDisplay.text = "This is not a valid input please input a number"
            return
        }else {
            val tipTen = stringInTextField.toDouble() + stringInTextField.toDouble() * 0.1
            val tip15 = stringInTextField.toDouble() + stringInTextField.toDouble() * 0.15
            val tipTwenty = stringInTextField.toDouble() + stringInTextField.toDouble() * 0.2
            binding.tipDefaultDisplay.text = "The tips are as follows \n 10% = " + tipTen + "\n 15% = "+ tip15 + "\n 20% = " + tipTwenty
        }


    }

}


