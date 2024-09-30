package com.example.conversor_grados

class Kelvin(val value: Double) {

    companion object {
        fun parse(celsius: Celsius): Kelvin {
            val kelvinValue = celsius.value + 273.15
            return Kelvin(kelvinValue)
        }

        fun parse(fahrenheit: Faren): Kelvin {
            val kelvinValue = (fahrenheit.value - 32) * 5 / 9 + 273.15
            return Kelvin(kelvinValue)
        }
    }
}
