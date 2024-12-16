package com.example.tab_layout2


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class InformacionLegalActivity : AppCompatActivity() {
    private lateinit var botonAceptar: Button//crear el objeto de Tabla
    private lateinit var botonCancelar: Button
    private lateinit var botonModificar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_legal)

        botonAceptar = findViewById(R.id.btnAceptar)
        botonCancelar = findViewById(R.id.btnCancelar)
        botonModificar = findViewById(R.id.btnModificar)


        botonAceptar.setOnClickListener{
            val intent = Intent()
            //intent.putExtra("resultado","valor")
            intent.putExtra("Usuario","Pepe")

            //esta poniendo en el intent el resultado ok
            setResult(Activity.RESULT_OK,intent)
            //acaba la actividad(ventana)
            finish()
        }
        botonCancelar.setOnClickListener{
            val intent = Intent()
            intent.putExtra("Usuario","Pepe")

            //esta poniendo en el intent el resultado ok
            setResult(Activity.RESULT_CANCELED,intent)
            //acaba la actividad(ventana)
            finish()
        }
        botonModificar.setOnClickListener{
            val intent = Intent()
            intent.putExtra("Usuario","Pepe")

            //esta poniendo en el intent el resultado ok
            setResult(Activity.RESULT_FIRST_USER,intent)
            //acaba la actividad(ventana)
            finish()
        }

    }
}