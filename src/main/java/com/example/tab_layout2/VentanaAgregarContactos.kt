package com.example.tab_layout2

import com.example.tab_layout2.DB.DBConexion
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VentanaAgregarContactos : AppCompatActivity() {

    private lateinit var  botonAceptar: Button
    private lateinit var  txtNombre: EditText
    private lateinit var  txtEmail: EditText
    private lateinit var  txtTelefono: EditText

    var conexion: DBConexion?= null
    var db: SQLiteDatabase? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_agregar_contacto)
        txtNombre = findViewById(R.id.txtNombre)
        txtEmail = findViewById(R.id.txtemail)
        txtTelefono = findViewById(R.id.telefono)
        botonAceptar = findViewById(R.id.btnAceptar)



        //creamos el objeto conexion con la ventana actual
        //estas sentencias de conexion y obtencion de la BBDD
        //se repite en todas las ventanas sobre los que se va a operar en la BBDD

        conexion = DBConexion(this)
        db = conexion!!.writableDatabase

            //recojo en variables lo que esta escrito en los campos de texto de las ventanas
        botonAceptar.setOnClickListener{
            val intent = Intent()
            val nombre = txtNombre.text.toString()
            val email = txtEmail.text.toString()
            val tfno = txtTelefono.textScaleX.toString()

            //creo nuevo objeto contacto
            val contactoNuevo = Contacto(nombre,email,tfno,0)

            //intento insertarlos en la BBDD el objeto contactoNuevo

            if (db != null) {
                conexion!!.insertContacto(db, contactoNuevo)  // no se puede poner esto nombre,email,tfno,0 como en la linea 47
            }

                //muestra un aviso de que se ha añadido un nuevo contacto.
            Toast.makeText(this,"Se ha añadido un nuevo contacto", Toast.LENGTH_LONG).show()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }
}