package com.example.hobies_viajes

import android.graphics.Bitmap

data class Viaje(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val pais: String,
    val foto: Bitmap

)

