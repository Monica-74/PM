package com.example.hobies_viajes


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

class PestanasActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pestana)

        // Inicializamos las vistas
        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tablayout)

        // Configuración del Toolbar como barra de herramientas superior de la aplicación
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Hobbies y Viajes"

        // Configuración del ViewPager y las pestañas, se utiliza para permitir la navegación deslizante
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Hobbies"
                1 -> "Viajes"
                else -> null
            }
        }.attach()

        // Configurar los iconos para navegar a nuevas actividades
        val infoIcon = findViewById<ImageView>(R.id.info_icon)
        val hobbiesIcon = findViewById<ImageView>(R.id.hobbies_icon)

        // Acción para el icono de información
        infoIcon.setOnClickListener {
            val intent = Intent(this, AñadirInformacionActivity::class.java)
            startActivity(intent)
        }

        // Acción para el icono de añadir hobbies
        hobbiesIcon.setOnClickListener {
            val intent = Intent(this, AñadirHobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}


