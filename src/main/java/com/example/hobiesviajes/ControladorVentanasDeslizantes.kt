package com.example.hobiesviajes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ControladorVentanasDeslizantes (supportFragmentManager: FragmentManager):
    FragmentStatePagerAdapter(supportFragmentManager){
    //declarar una lista con los fragmentos y sus titulos
    private val  listaFragmentos= ArrayList<Fragment>()
    private val  listaTitulosFragmentos= ArrayList<String>()

    fun addFragment(fragment: ViajeFragment, title: String){
        listaFragmentos.add(fragment)
        listaTitulosFragmentos.add(title)
    }

    //retornar un item en una posicion determinada
    override fun getItem(position: Int): Fragment {
        return listaFragmentos[position]
    }

    override fun getCount():Int{
        return listaFragmentos.size
    }

    override fun getPageTitle(position: Int): String {
        return listaTitulosFragmentos[position]
    }



}