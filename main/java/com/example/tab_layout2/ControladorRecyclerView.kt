package com.example.tab_layout2


import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView

class ControladorRecyclerView (private val contactosList:ArrayList<Contacto>): RecyclerView.Adapter<VistaContacto>() {

    //    este metodo crea un nuevo viewHolder o wrapper para cada elemento de la lista REcyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaContacto {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contacto_item_layout, parent, false)
        return VistaContacto(view)
    }

    override fun getItemCount(): Int {
        return contactosList.size
    }

    //para mostrar la forma eue le decimos que los pinte, que es indicada por ViewHolder
    override fun onBindViewHolder(holder: VistaContacto, position: Int) {
        val contacto = contactosList[position]
        holder.nombre?.text = contacto.nombre
        holder.email?.text = contacto.email
        holder.tlfn?.text = contacto.tfno
        holder.foto?.setImageResource(contacto.foto)

    }
}

class VistaContacto(itemView:View?) : RecyclerView.ViewHolder(itemView!!){
    val nombre:TextView? = itemView?.findViewById(R.id.contacto)
    val email:TextView? = itemView?.findViewById(R.id.email)
    val tlfn:TextView? = itemView?.findViewById(R.id.telefono)
    val foto:ImageView? = itemView?.findViewById(R.id.foto)

}


