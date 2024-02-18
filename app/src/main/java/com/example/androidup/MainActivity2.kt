package com.example.androidup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.androidup.databinding.ActivityMain2Binding
import java.lang.NumberFormatException

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val outputTextView = binding.outputTextView
        val outputUnitTextView = binding.outputUnitTextView
        val inputEditText = binding.inputEditView
        val inputUintTextView = binding.inputUnitTextView
        val swapImageButton = binding.swapImageButton

        var inputNumber : Int = 0
        var cmToM = true

        inputEditText.addTextChangedListener{ text ->
            inputNumber = if(text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
            }

            var outputNumber = inputNumber.times(0.01)
            if(cmToM) {
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }
            outputTextView.text = outputNumber.toString()
        }
        swapImageButton.setOnClickListener{
            cmToM = cmToM.not()
            if(cmToM) {
                inputUintTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                inputUintTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val cmToM = false
        outState.putBoolean("cmToM", cmToM)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        var cmToM = savedInstanceState.getBoolean("cmToM")
        super.onRestoreInstanceState(savedInstanceState)
    }
}