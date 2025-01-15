package com.example.hobies_viajes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var txtLogin : EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnAceptar : Button
    private lateinit var btnCancelar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Obtenemos una referencia a los controles de la interfaz
        txtLogin = findViewById(R.id.txtLogin)
        txtPassword = findViewById(R.id.txtPassword)
        btnAceptar = findViewById(R.id.btnAceptar)
        btnCancelar = findViewById(R.id.btnCancelar)


        //Boton Aceptar, que le voy a añadir una acción
        btnAceptar.setOnClickListener {
            //Añadimos al intent la información a pasar entre actividades el parámetro que le voy a pasar se llama "NOMBRE" y su valor es lo que está escrito en el txtoNombre
            val login = txtLogin.text.toString()
            val password = txtPassword.text.toString()
            //valido mi contraseña
            if (login.isNotEmpty() && password.isNotEmpty()) {
                if (login == "Monica" && password == "1234") {
//                Pasamos los datos a la siguiente pestaña
                    val intent = Intent(this@MainActivity, PestanasActivity::class.java)
                    intent.putExtra("LOGIN", login)
                    intent.putExtra("PASSWORD", password)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "Login o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
       //Boton Aceptar, que le voy a añadir una acción
        btnCancelar.setOnClickListener {
        //finalizo la acitividad
            finish()
        }

    }
}