package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Editar_perfi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)
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
}