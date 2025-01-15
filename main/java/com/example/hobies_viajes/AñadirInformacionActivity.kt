package com.example.hobies_viajes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AñadirInformacionActivity : AppCompatActivity() {

    private lateinit var btn_aceptar1: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_informacion)


        btn_aceptar1 = findViewById(R.id.btn_aceptar1)

        btn_aceptar1.setOnClickListener {
          val intent = Intent(this@AñadirInformacionActivity, MainActivity::class.java)
           startActivity(intent) // Inicia la nueva actividad (MainActivity)
             Toast.makeText(this, "Información aceptada", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

