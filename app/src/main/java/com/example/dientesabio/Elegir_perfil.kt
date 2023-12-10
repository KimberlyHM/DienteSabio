package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Elegir_perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elige_perfil)
    }

    fun regresar(view: View){
        super.onBackPressed()
    }

    fun inicio(view: View){
        val i = Intent(this,Inicio::class.java)
        startActivity(i)
    }
}