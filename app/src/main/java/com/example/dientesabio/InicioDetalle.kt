package com.example.dientesabio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dientesabio.data.InicioTemas

class InicioDetalle  : AppCompatActivity() {
    //lateinit var tema : InicioTemas
    lateinit var datosTemas : InicioTemas
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_detalle)

        //datos que se eligen
       // tema = intent.getParcelableExtra<InicioTemas>("Tema")!!
        datosTemas= intent.getParcelableExtra<InicioTemas>("datosTemas")!!



        val nombre : TextView = findViewById(R.id.titulo_item)
        nombre.text = datosTemas.nombre
        val desc : TextView = findViewById(R.id.item_descripcion)
        desc.text = datosTemas.descripcion
        val imagen : ImageView = findViewById(R.id.imagen_item)
        imagen.setImageResource(datosTemas.imagen)
    }

    fun ir_buscar(view: View){
        val i = Intent(this,Buscar::class.java)
        startActivity(i)
    }

    fun inicio(view: View){
        val i = Intent(this,Inicio::class.java)
        startActivity(i)
    }

    fun ir_guardados(view: View){
        val i = Intent(this,Guardados::class.java)
        startActivity(i)
    }
}