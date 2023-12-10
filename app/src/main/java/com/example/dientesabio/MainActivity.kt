package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun ingresar_datos(view: View){
        val i = Intent(this,Ingresar::class.java)
        startActivity(i)
    }

    fun registrar_datos(view: View){
        val i = Intent(this,Crear_perfil::class.java)
        startActivity(i)
    }

}
