package com.example.conversor_grados

class Faren(val value: Double) {

    companion object {
        fun parse(celsius: Celsius): Faren {
            val fahrenheitValue = (celsius.value * 9 / 5) + 32
            return Faren(fahrenheitValue)
        }

        fun parse(kelvin: Kelvin): Faren {
            val fahrenheitValue = (kelvin.value - 273.15) * 9 / 5 + 32
            return Faren(fahrenheitValue)
        }
    }
}