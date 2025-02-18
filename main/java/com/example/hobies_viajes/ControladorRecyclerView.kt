package com.example.hobies_viajes



import DDBB.MonicaDB
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
//import androidx.componse.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView



private var Any.text: String
    get() {return String.toString() }
    set(value) {}

class ControladorRecyclerView (private var viajesList: ArrayList<Viaje>): RecyclerView.Adapter<ControladorRecyclerView.VistaViajes>() {

    //    este metodo crea un nuevo viewHolder o wrapper para cada elemento de la lista REcyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaViajes {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_viajes, parent, false) // o fragment_viaje
        return VistaViajes(view)
    }

    override fun getItemCount(): Int {
        return viajesList.size
    }


    override fun onBindViewHolder(holder: VistaViajes, position: Int) {  //ControladorRecyclerView.VistaViajes
        val viaje = viajesList[position]
        holder.nombre?.text = viaje.nombre
        holder.descripcion?.text = viaje.descripcion
        holder.pais?.text = viaje.pais

//        // Convertir byte[] a Bitmap
//        val fotoBitmap = BitmapFactory.decodeByteArray(viaje.foto,0,viaje.foto.size)
//        holder.foto?.setImageBitmap(fotoBitmap)
//
//    }
//        val resourceId = holder.itemView.context.resources.getIdentifier(

//        holder.foto?.setImageBitmap(viaje.foto)
//    }

//desde aqui hasta cierrra metodo
//        // Obtén el identificador del recurso usando el nombre de la imagen
        val resourceId = holder.itemView.context.resources.getIdentifier(

            viaje.foto.toString(), // Nombre del recurso (por ejemplo, "viaje")
            "drawable", // Tipo de recurso (drawable)
            holder.itemView.context.packageName // Paquete de la aplicación
        )

        // Si el recurso existe, asigna la imagen; de lo contrario, usa una imagen por defecto
        if (resourceId != 0) {
            holder.foto?.setImageResource(resourceId)
        } else {
            holder.foto?.setImageResource(R.drawable.fotoviaje) // Imagen por defecto
        }
    }

    fun updateData(newViajes: List<Viaje>) {
        //viajesList = newViajes as ArrayList<Viaje>
        viajesList.clear()
        viajesList.addAll(newViajes)
        notifyDataSetChanged()
    }


    //esta clase define el ViewHolder para cada item de la lista del controlador anterior
    class VistaViajes(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val nombre: TextView? = itemView?.findViewById(R.id.nombreViaje)
        val descripcion: TextView? = itemView?.findViewById(R.id.descripcionViaje)
        val pais: TextView? = itemView?.findViewById(R.id.paisViaje)
        val foto: ImageView? = itemView?.findViewById(R.id.fotoviaje)

    }

    // Método para cargar los viajes desde la base de datos

    private fun cargarViajesDesdeBD(context: Context) {//
        val monicaDB = MonicaDB(context)
        val db = monicaDB.readableDatabase

        // Obtener la lista de viajes desde la base de datos
        val newViajesList = monicaDB.insertarViaje(db)

        if (newViajesList.isNotEmpty()) {
            // Actualizar la lista y notificar al adaptador
            updateData(newViajesList)
        } else {
            Toast.makeText(context, "No hay viajes guardados", Toast.LENGTH_SHORT).show()
        }

        db.close()
    }


}


