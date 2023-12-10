package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pefil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pefil)
    }

    fun regresar(view: View){
        super.onBackPressed()
    }

    fun datos_usuario(view: View){
        val i = Intent(this,Editar_perfi::class.java)
        startActivity(i)
    }

    fun ir_comentarios(view: View){
        val i = Intent(this,Comentarios::class.java)
        startActivity(i)
    }

    fun ir_politicas(view: View){
        val i = Intent(this,Politicas::class.java)
        startActivity(i)
    }

    fun ir_ajustes(view: View){
        val i = Intent(this,Configuracion::class.java)
        startActivity(i)
    }
    fun ir_historial(view: View){
        val i = Intent(this,Historial::class.java)
        startActivity(i)
    }

}