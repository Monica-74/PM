package com.example.hobies_viajes


import DDBB.MonicaDB
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import java.util.ArrayList


class PestanasActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ControladorRecyclerView
    private lateinit var obtenerViaje: Viaje
    //private val listaViajes = mutableListOf<Viaje>() // Lista mutable para almacenar los viajes

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pestana)

        // Inicializar vistas
        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tablayout)

        // Cargar los viajes desde la base de datos
        //cargarViajesDesdeBD()//quito ahora

        // Configuración del Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Hobbies y Viajes"

        // Configuración de las pestañas con ViewPager
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Hobbies"
                1 -> "Viajes"
                else -> null
            }
        }.attach()

        // Botón para añadir Hobbies
        val btnHobbies = findViewById<Button>(R.id.btnHobbies)
        btnHobbies.setOnClickListener {
            val intent = Intent(this, AnadirInformacionActivity::class.java)
            startActivity(intent)
        }

        // Botón para añadir Viajes
        val btnViajes = findViewById<Button>(R.id.btnAceptarViajes)
        btnViajes.setOnClickListener {
            val intent = Intent(this, AnadirNuevoViajesActivity::class.java)
            startActivity(intent)
        }
        val btnVerViajes = findViewById<Button>(R.id.btnVerViajes)
        btnVerViajes.setOnClickListener {
            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = ControladorRecyclerView(ArrayList())
            recyclerView.adapter = adapter
            cargarViajesDesdeBD() // Debe cargar los datos después de inicializar el adapter
        }


       //desde aqui hasta final metodo
//        val btnVerViajes = findViewById<Button>(R.id.btnVerViajes)
//        btnVerViajes.setOnClickListener() {
//           cargarViajesDesdeBD()
//            recyclerView = findViewById(R.id.recyclerView)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            //val listaViajes = arrayListOf<Viaje>()
//            adapter = ControladorRecyclerView(ArrayList())
//            recyclerView.adapter = adapter
//            cargarViajesDesdeBD()
//
////            val intent = Intent(this, ViajesFragment::class.java)// esto lo he quitado ahora
////            //obtenerViajeBBDD//quito ahora
////            // val intent = Intent(this, AñadirNuevoViajesActivity::class.java)
////            startActivity(intent) //esto lo he quitado ahora
//
//
//            // Configurar RecyclerView

        }




    //esto es nuevo
    private fun cargarViajesDesdeBD() {
        val monicaDB = MonicaDB(this)
        val db = monicaDB.readableDatabase

        // Usar el método selectViajes de MonicaDB
        val viajesList = monicaDB.insertarViaje(db)?: ArrayList()

        if (viajesList.isNotEmpty()) {
            adapter.updateData(viajesList) // Actualizar el adaptador con los viajes
        } else {
            Toast.makeText(this, "No hay viajes guardados", Toast.LENGTH_SHORT).show()
        }


        // Actualizar el RecyclerView con los datos

        db.close()
    }
}







