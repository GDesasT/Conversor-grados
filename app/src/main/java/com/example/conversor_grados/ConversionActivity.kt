package com.example.conversor_grados.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.conversor_grados.*

class ConversionActivity : AppCompatActivity() {

    private lateinit var editValue: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var buttonConvert: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        editValue = findViewById(R.id.edit_value)
        spinnerFrom = findViewById(R.id.spinner_from)
        spinnerTo = findViewById(R.id.spinner_to)
        buttonConvert = findViewById(R.id.button_convert)
        textResult = findViewById(R.id.text_result)

        val units = arrayOf("Celsius", "Fahrenheit", "Kelvin")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        buttonConvert.setOnClickListener {
            val inputValue = editValue.text.toString()
            if (inputValue.isNotEmpty()) {
                val value = inputValue.toDouble()
                val fromUnit = spinnerFrom.selectedItem.toString()
                val toUnit = spinnerTo.selectedItem.toString()

                val result = convertUsingClasses(value, fromUnit, toUnit)
                textResult.text = "Resultado: $result $toUnit"
            } else {
                textResult.text = "Por favor, ingrese un valor"
            }
        }
    }

    private fun convertUsingClasses(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit) {
            "Celsius" -> {
                val celsius = Celsius(value)
                when (toUnit) {
                    "Fahrenheit" -> Faren.parse(celsius).value
                    "Kelvin" -> Kelvin.parse(celsius).value
                    else -> celsius.value
                }
            }
            "Fahrenheit" -> {
                val fahrenheit = Faren(value)
                when (toUnit) {
                    "Celsius" -> Celsius.parse(fahrenheit).value
                    "Kelvin" -> Kelvin.parse(fahrenheit).value
                    else -> fahrenheit.value
                }
            }
            "Kelvin" -> {
                val kelvin = Kelvin(value)
                when (toUnit) {
                    "Celsius" -> Celsius.parse(kelvin).value
                    "Fahrenheit" -> Faren.parse(kelvin).value
                    else -> kelvin.value
                }
            }
            else -> value
        }
    }
}
