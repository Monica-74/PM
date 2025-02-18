package com.example.hobies_viajes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var txtLogin: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnAceptar: Button
    private lateinit var btnCancelar: Button
    private lateinit var ventanaDeslizante: ViewPager
    private lateinit var tablayout: TabLayout
    private lateinit var txtTexto: TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLogin = findViewById(R.id.txtLogin)
        txtPassword = findViewById(R.id.txtPassword)
        btnAceptar = findViewById(R.id.btnAceptar)
        btnCancelar = findViewById(R.id.btnCancelar)
        //txtTexto = findViewById(R.id.txtTextoInformacion)

        btnAceptar.setOnClickListener {
            val login = txtLogin.text.toString()
            val password = txtPassword.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                if (login == "Monica" && password == "1234") {
                    val intent = Intent(this, PestanasActivity::class.java)
                    intent.putExtra("LOGIN", login)
                    intent.putExtra("PASSWORD", password)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this, "Login o contraseña incorrectos", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT)
                    .show()
            }
        }



        btnCancelar.setOnClickListener {
            finish()
        }
    }
}
