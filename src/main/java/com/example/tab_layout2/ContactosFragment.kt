package com.example.tab_layout2

import com.example.tab_layout2.DB.DBConexion
import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ContactosFragment : Fragment() {
    private lateinit var  botonAgregarContacto: Button
    protected var mAdapter: ControladorRecyclerView? = null
    private lateinit var botonContactoNuevo :Button
    var listaContactos = ArrayList<Contacto>()

    //BBD
    var conexion: DBConexion? = null
    var dB: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //conectarse a esa base de datos
        //se repiten en todas las ventanas que operen con BBDD
        conexion = DBConexion(this.context)
        dB = conexion!!.writableDatabase
        if (dB != null) {
            //inicia los datos
            //prueba los datos obtenidos de una BBDD
            iniciarRecogidaDatos(conexion, dB)
        }
    }

    //falta de los apuntes tengo que poner el metodo de actualizacion

//    override fun onResume(){
//        super.onResume();
//    }


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView: View = inflater.inflate(R.layout.fragment_contactos, container, false)
        rootView.tag = "ContactosFragment"

        mAdapter = ControladorRecyclerView(listaContactos)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerViewListaContactos)
        //para que sea linear para definir el deslizamiento de los items del reciclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        //El controlador del recycler view particular mio,va a ser el controlador arriba definido
        //que he creado a partir de la lista de contactos.
        //donde se vincula el componenete grafico widget recycler view con el controlador adapter
        //para mostrar los datos


        recyclerView!!.adapter = mAdapter

        botonAgregarContacto = rootView.findViewById(R.id.btNuevoContacto)

        botonAgregarContacto.setOnClickListener{
            val intent = Intent( context, VentanaAgregarContactos::class.java)
            startActivity(intent)
        }
            return rootView
        }


        private fun iniciarRecogidaDatos(conexion: DBConexion?, dB: SQLiteDatabase?) {
            //aqui es dd podemos leer los datos de una BDD
            if (conexion != null) {
                listaContactos = conexion.selectContactos(dB) as ArrayList<Contacto>
            }
        }
    }


