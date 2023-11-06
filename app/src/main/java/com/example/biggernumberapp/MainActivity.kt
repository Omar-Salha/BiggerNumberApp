package com.example.biggernumberapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.biggernumberapp.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        assignRandomNums()

        binding.btnLeft.setOnClickListener {
            checkValues(true)
            assignRandomNums()
        }

        binding.btnRight.setOnClickListener {
            checkValues(false)
            assignRandomNums()
        }
    }

    private fun checkValues(isLeftChecked: Boolean) {
        val leftNum: Int = binding.btnLeft.text.toString().toInt()
        val rightNum: Int = binding.btnRight.text.toString().toInt()

        val isAnswerCorrect = if (isLeftChecked) leftNum > rightNum else rightNum > leftNum

        if (isAnswerCorrect) {
            binding.backgroundView.setBackgroundColor(Color.GREEN)

            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
        }
        else {
            binding.backgroundView.setBackgroundColor(Color.RED)

            Toast.makeText(this, "WRONG!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignRandomNums() {
        var leftNum = Random.nextInt(0..100)
        val rightNum = Random.nextInt(0..100)

        while (leftNum == rightNum) {
            leftNum = Random.nextInt(0..100)
        }

        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }

}