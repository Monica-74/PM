package com.example.hobies_viajes


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2 // pestaña hobbies y viajes
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HobbiesFragment() // Fragmento para "Hobbies"
            1->ViajesFragment()
            //1 -> ViajesFragment( "nombre","descripcion","pais",R.drawable.fotoviaje)  // Fragmento para "Viajes"
            else -> throw IllegalStateException("Posición desconocida: $position")
        }
    }
}
