package com.example.conversor_grados.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.conversor_grados.R

class MainActivity : AppCompatActivity() {

    private lateinit var buttonStartConversion: Button
    private lateinit var textViewCountdown: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottieAnimationView)
        buttonStartConversion = findViewById(R.id.button_start_conversion)
        textViewCountdown = findViewById(R.id.textViewCountdown)

        // Configurar el comportamiento del botón
        buttonStartConversion.setOnClickListener {
            buttonStartConversion.isEnabled = false // Deshabilitar el botón mientras se hace la cuenta regresiva
            textViewCountdown.visibility = View.VISIBLE // Mostrar el texto de cuenta regresiva

            // Crear y empezar el temporizador de 5 segundos
            object : CountDownTimer(5000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // Actualizar el texto de la cuenta regresiva
                    textViewCountdown.text = "Redireccionando en: ${millisUntilFinished / 1000} segundos"
                }

                override fun onFinish() {
                    // Cuando termina la cuenta regresiva, redirigir a la siguiente actividad
                    textViewCountdown.text = ""
                    val intent = Intent(this@MainActivity, ConversionActivity::class.java)
                    startActivity(intent)
                    finish() // Finaliza la actividad actual para evitar regresar a ella con el botón atrás
                }
            }.start()
        }
    }
}
