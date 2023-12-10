package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Crear_perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_perfil)
    }

    fun regresar(view: View){
        super.onBackPressed()
    }

    fun elegir_perfil(view: View){
        val i = Intent(this,Elegir_perfil::class.java)
        startActivity(i)
    }
}