package com.example.hobies_viajes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AnadirHobbiesActivity : AppCompatActivity() {
    private lateinit var btn_aceptar2: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_hobbies)

        val txtAnadirHobbies = findViewById<TextView>(R.id.btnAceptar)
        val btnAceptar = findViewById<Button>(R.id.btn_aceptar2)

        txtAnadirHobbies.visibility = View.GONE // Oculta el texto
        btnAceptar.visibility = View.GONE // Oculta el botón
    }


    // @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_anadir_hobbies)
//
//        btn_aceptar2 = findViewById(R.id.btn_aceptar2)
//
//        btn_aceptar2.setOnClickListener {
//            val intent = Intent(this@AnadirHobbiesActivity, MainActivity::class.java)
//            startActivity(intent) // Inicia la nueva actividad (MainActivity)
//            Toast.makeText(this, "Información aceptada", Toast.LENGTH_SHORT).show()
//            finish()
//        }
//    }
}


