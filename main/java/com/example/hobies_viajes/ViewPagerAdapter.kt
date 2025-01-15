package com.example.hobies_viajes


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2 // Número de pestañas
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HobbiesFragment() // Fragmento para "Hobbies"
            1 -> ViajesFragment()  // Fragmento para "Viajes"
            else -> throw IllegalStateException("Posición desconocida: $position")
        }
    }
}
