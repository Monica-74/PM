package com.example.tab_layout2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ContactosFragment : Fragment() {

    protected  var mAdapter:ControladorRecyclerView?= null

    val listaContactos= ArrayList<Contacto>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        iniciarRecogidaDatos()
    }



    @SuppressLint("MissingIn")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView:View = inflater.inflate(R.layout.fragment_contactos,container,false)
        rootView.tag = "ContactosFragment"

        mAdapter = ControladorRecyclerView(listaContactos)

        val recyclerView:RecyclerView=rootView.findViewById(R.id.recyclerViewListaContactos)
        //para que sea linear para definir el deslizamiento de los items del reciclerview
        recyclerView.layoutManager =LinearLayoutManager(context)
        //El controlador del recycler view particular mio,va a ser el controlador arriba definido
        //que he creado a partir de la lista de contactos.
        //donde se vincula el componenete grafico widget recycler view con el controlador adapter
        //para mostrar los datos


        recyclerView!!.adapter =mAdapter

        return rootView
    }


    private fun iniciarRecogidaDatos(){
        val cont1=Contacto("Contacto1","contacto@gmail.com","123456", R.drawable.baseline_person_3_24)
        val cont2=Contacto("Contacto2","contacto@gmail.com","123456", R.drawable.baseline_person_4_24)
        val cont3=Contacto("Contacto3","contacto@gmail.com","123456", R.drawable.baseline_person_3_24)
        val cont4=Contacto("Contacto4","contacto@gmail.com","123456", R.drawable.baseline_person_4_24)
        listaContactos.add(cont1);
        listaContactos.add(cont2);
        listaContactos.add(cont3);
        listaContactos.add(cont4);

    }



}