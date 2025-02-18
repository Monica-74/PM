package com.example.hobies_viajes


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class ControladorVentanasDeslizantes(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


//class ControladorVentanasDeslizantes (supportFragmentManager: FragmentManager):
//    FragmentStatePagerAdapter(supportFragmentManager){
    //declarar una lista con los fragmentos y sus titulos
    private val  listaFragmentos= ArrayList<Fragment>()
//    private val  listaTitulosFragmentos= ArrayList<String>()

    fun addFragment(fragment: Fragment){
        listaFragmentos.add(fragment)
//        listaTitulosFragmentos.add(title)
    }


    override fun getItemCount(): Int {
        return listaFragmentos.size
    }

    override fun createFragment(position: Int): Fragment {
      return listaFragmentos[position]
    }


}