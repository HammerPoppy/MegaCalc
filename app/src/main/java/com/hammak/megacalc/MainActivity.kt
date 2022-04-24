package com.hammak.megacalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var bMultiply: Button
    lateinit var bDivide: Button
    lateinit var bPlus: Button
    lateinit var bMinus: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bMultiply = findViewById(R.id.bMultiply)
        bDivide = findViewById(R.id.bDivide)
        bPlus = findViewById(R.id.bPlus)
        bMinus = findViewById(R.id.bMinus)

        bMultiply.setOnClickListener(mainOnClickListener())
        bDivide.setOnClickListener(mainOnClickListener())
        bPlus.setOnClickListener(mainOnClickListener())
        bMinus.setOnClickListener(mainOnClickListener())
    }

    private fun mainOnClickListener(): View.OnClickListener {
        return View.OnClickListener {
            it.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
            val first = findViewById<EditText>(R.id.etFirst).text.toString().toDoubleOrNull()
            val second = findViewById<EditText>(R.id.etSecond).text.toString().toDoubleOrNull()

            if (first != null && second != null) {
                when (it.id){
                    R.id.bMultiply -> updateResultLabel(first * second)
                    R.id.bDivide -> updateResultLabel(first / second)
                    R.id.bPlus -> updateResultLabel(first + second)
                    R.id.bMinus -> updateResultLabel(first - second)
                }
            }
        }
    }

    private fun updateResultLabel(result: Double) {
        findViewById<TextView>(R.id.tvResultValue).text = result.toString()
    }
}