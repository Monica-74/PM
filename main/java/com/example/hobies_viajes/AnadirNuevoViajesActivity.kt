package com.example.hobies_viajes


import DDBB.MonicaDB
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AnadirNuevoViajesActivity : AppCompatActivity() {
    private lateinit var nombreEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var paisEditText: EditText
    private lateinit var fotoImageView: ImageView
    private lateinit var btnAgregarViajes: Button
    private lateinit var btnCancelarViaje: Button
    private lateinit var conexion: MonicaDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_viajes)
        //setContentView(R.layout.activity_pestana)//cambio esto
        // Insertar datos de prueba
        //insertarDatosDePrueba()//cambio esto
        // Inicializamos las vistas
        nombreEditText = findViewById(R.id.nombre)
        descripcionEditText = findViewById(R.id.descripcion)
        paisEditText = findViewById(R.id.Pais)
        fotoImageView = findViewById(R.id.fotoviaje)
        btnAgregarViajes = findViewById(R.id.btnAceptarViajes)
        btnCancelarViaje = findViewById(R.id.btnCancelarViajes)

        // Botón para cancelar
        btnCancelarViaje.setOnClickListener {
            finish()
        }

        // Botón para guardar en la base de datos
        btnAgregarViajes.setOnClickListener {
            insertarViaje()
        }
    }

    private fun insertarViaje() {
        val nombre = nombreEditText.text.toString()
        val descripcion = descripcionEditText.text.toString()
        val pais = paisEditText.text.toString()

        // Validar que todos los campos están completos
        if (nombre.isEmpty() || descripcion.isEmpty() || pais.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val fotoBlob = imageViewToByte(fotoImageView)
        val viajeNuevo = Viaje(0, nombre, descripcion, pais, fotoBlob)

        // Guardar en la base de datos
        //conexion = MonicaDB(this)

        val db = conexion.writableDatabase
        conexion.guardarViajes(db, viajeNuevo,)
        db.close()
//        if (db != null) {
//            val viajeNuevo = Viaje(
//                1,
//                nombre,
//                descripcion,
//                pais,
//                fotoBlob
//            )
            //conexion.guardarViaje(db, viajeNuevo, this.baseContext)



        Toast.makeText(this, "Viaje guardado correctamente", Toast.LENGTH_SHORT).show()
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun imageViewToByte(imageView: ImageView): Bitmap {
        return if (imageView.drawable != null) {
            (imageView.drawable as BitmapDrawable).bitmap
        } else {
            // Manejar caso donde no hay imagen
            BitmapFactory.decodeResource(resources, R.drawable.fotoviaje)
        }
    }
}




















