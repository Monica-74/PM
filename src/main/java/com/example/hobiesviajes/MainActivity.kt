package com.example.hobiesviajes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var txtLogin :     EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnAceptar : Button
    private lateinit var btnCancelar: Button


    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Aquí especifico el layout que he creado antes
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        //Obtenemos una referencia a los controles de la interfaz
        txtLogin = findViewById(R.id.txtLogin)
        txtPassword = findViewById(R.id.txtPassword)
        //txtNombre.setBackgroundColor(Color.Blue)
        // Así accedo al boton aceptar al cual le voy a agregar un listener
        btnAceptar = findViewById(R.id.btnAceptar)
        btnCancelar = findViewById(R.id.btnCancelar)

        //Botoncito, que le voy a añadir una acción
        btnAceptar.setOnClickListener {
            val intent = Intent(this@MainActivity, PestanasActivity::class.java)
            //Añadimos al intent la información a pasar entre actividades
            //el parámetro que le voy a pasar se llama "NOMBRE"
            //y su valor es lo que está escrito en el txtoNombre
            val Login = txtLogin.text.toString()
            val Password = txtPassword.text.toString()
            if (Login == "Monica" || Password == "1234") {

                 intent.putExtra("LOGIN", txtLogin.text.toString())
                 intent.putExtra("PASSWORD", txtLogin.text.toString())
                startActivity(intent)
            }

        }
        btnCancelar.setOnClickListener {

            finish()
            }

        }
    }




