package com.example.hobies_viajes

import DDBB.MonicaDB
import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//class ViajesFragment : Fragment() {
//
//    private lateinit var db: SQLiteDatabase
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var mAdapter: ControladorRecyclerView
//    private lateinit var monicaDB: MonicaDB
//    private val listaViajes = ArrayList<Viaje>()
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflar la vista correctamente
//        val rootView = inflater.inflate(R.layout.fragment_viajes, container, false) // Asegúrate de que el layout sea fragment_viajes
//
//        // Inicializar base de datos
//        monicaDB = MonicaDB(requireContext())
//
//        // Configurar RecyclerView
//        recyclerView = rootView.findViewById(R.id.recyclerViewViajes)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        mAdapter = ControladorRecyclerView(listaViajes)
//        recyclerView.adapter = mAdapter
//
//        return rootView
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Botón para agregar un nuevo viaje
//        val btnAgregarViajes = view.findViewById<Button>(R.id.btnAceptarViajes)
//        btnAgregarViajes.setOnClickListener {
//            val intent = Intent(requireContext(), AnadirNuevoViajesActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Botón para ver los viajes guardados en la BD
//        val btnVerViajes = view.findViewById<Button>(R.id.btnVerViajes)
//        btnVerViajes.setOnClickListener {
//            cargarViajesDesdeBD()
//        }
//
//        // Cargar viajes de la BD al inicio
//        cargarViajesDesdeBD()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        cargarViajesDesdeBD() // Recargar viajes cuando el fragmento esté activo
//    }
//
//    private fun cargarViajesDesdeBD() {
//        val db = monicaDB.readableDatabase
//        val viajesList = monicaDB.listaViajes(db) // Usar el método listaViajes de MonicaDB
//
//        if (viajesList.isNotEmpty()) {
//            mAdapter.updateData(viajesList) // Actualizar el adaptador con los viajes
//        } else {
//            Toast.makeText(requireContext(), "No hay viajes guardados", Toast.LENGTH_SHORT).show()
//        }
//
//        db.close()
//    }
//}






class ViajesFragment : Fragment() {

    private lateinit var db: SQLiteDatabase
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: ControladorRecyclerView
    private lateinit var monicaDB: MonicaDB
    private val listaViajes = ArrayList<Viaje>()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar la vista correctamente
        val rootView = inflater.inflate(R.layout.fragment_viajes, container, false) //fragmet_viajes

        // Inicializar base de datos
        monicaDB = MonicaDB(requireContext())

        // Configurar RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerViewViajes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        mAdapter = ControladorRecyclerView(listaViajes)
        recyclerView.adapter = mAdapter

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón para agregar un nuevo viaje
        val btnAgregarViajes = view.findViewById<Button>(R.id.btnAceptarViajes)
        btnAgregarViajes.setOnClickListener {
            val intent = Intent(requireContext(), AnadirNuevoViajesActivity::class.java)
            startActivity(intent)
        }

        // Botón para ver los viajes guardados en la BD
        val btnVerViajes = view.findViewById<Button>(R.id.btnVerViajes)
        btnVerViajes.setOnClickListener {
            cargarViajesDesdeBD()
        }

        // Cargar viajes de la BD al inicio
       // cargarViajesDesdeBD()
    }

    override fun onResume() {
        super.onResume()
        cargarViajesDesdeBD() // Recargar viajes cuando el fragmento esté activo
    }
//    fun cargarViajesDesdeBD() {
//        val db = monicaDB.readableDatabase
//        val viajesList = monicaDB.listaViajes(db) // Usar el método listaViajes de MonicaDB
//
//        if (viajesList.isNotEmpty()) {
//            mAdapter.updateData(viajesList) // Actualizar el adaptador con los viajes
//        } else {
//            Toast.makeText(requireContext(), "No hay viajes guardados", Toast.LENGTH_SHORT).show()
//        }
//
//        db.close()
//    }


    private fun cargarViajesDesdeBD() {//para mi que esta era insertarViaje
        val db = monicaDB.readableDatabase
        val viajesList = monicaDB.insertarViaje(db) //listaviajes
        val cursor = db.rawQuery("SELECT * FROM viajes", null)

        if (cursor.moveToFirst()) {
            do {
                val viaje = Viaje(
                    cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    cursor.getString(cursor.getColumnIndexOrThrow("descripcion")),
                    cursor.getString(cursor.getColumnIndexOrThrow("pais")),
                    BitmapFactory.decodeResource(requireContext().resources, R.drawable.fotoviaje)
                )
                viajesList.add(viaje)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        // Actualizar RecyclerView con los datos de la BD
        //mAdapter.updateData()
    }
}












































































