package com.example.dientesabio.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dientesabio.R
import com.example.dientesabio.data.InicioTemas

class AdapterInicio(private val listaInicio : ArrayList<InicioTemas>) : RecyclerView.Adapter<AdapterInicio.ViewHolder>(){

    lateinit var context: Context
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var inicioId: Int = 0
        var inicioname : TextView = itemView.findViewById(R.id.titulo_item)
        var iniciodesc: TextView = itemView.findViewById(R.id.item_descripcion)
        var inicioimagen: ImageView = itemView.findViewById(R.id.imagen_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_listas_inicio,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaInicio.size
    }
     var onItemClick : ((InicioTemas) -> Unit)? = null
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val inicio = listaInicio[position]

        holder.inicioId = inicio.id
        holder.inicioname.text = inicio.nombre
        holder.iniciodesc.text = inicio.descripcion
        holder.inicioimagen.setImageResource(inicio.imagen)


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(inicio)
        }

    }
}