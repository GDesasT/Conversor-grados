package com.example.conversor_grados

class Celsius (val value: Double){

    companion object {
        fun parse(fahrenheit: Faren): Celsius {
            val celsiusValue = (fahrenheit.value - 32) * 5 / 9
            return Celsius(celsiusValue)
        }

        fun parse(kelvin: Kelvin): Celsius {
            val celsiusValue = kelvin.value - 273.15
            return Celsius(celsiusValue)
        }
    }
}