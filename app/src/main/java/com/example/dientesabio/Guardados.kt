package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Guardados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardados)
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


    fun regresar(view: View){
        super.onBackPressed()
    }

    fun ir_descargas(view: View){
        val i = Intent(this,Descargas::class.java)
        startActivity(i)
    }
}