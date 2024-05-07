package com.example.app_celsiusparafahrenheit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtCelsius = findViewById<EditText>(R.id.txtCelsius)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnConverter = findViewById<TextView>(R.id.btnConverter)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnConverter.setOnClickListener {
            if (txtCelsius.text.isEmpty()) {
                txtCelsius.error = "Digite a temperatura em Celsius"
            } else {
                val celsius = txtCelsius.text.toString().toDouble()
                val resultado: Double
                resultado = (9 * celsius + 160) / 5
                txtResultado.text = "$celsius Graus Celsius equivale a $resultado Graus " +
                        "Fahrenheit"
                txtCelsius.text.clear()
            }
        }

        btnLimpar.setOnClickListener {
            txtCelsius.text.clear()
            txtResultado.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}