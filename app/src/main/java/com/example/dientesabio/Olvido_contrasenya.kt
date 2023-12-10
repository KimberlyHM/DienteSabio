package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Olvido_contrasenya : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvido_contrasenya)
    }

    fun regresar(view: View){
        super.onBackPressed()
    }

    fun ingresar_datos(view: View){
        val i = Intent(this,Ingresar::class.java)
        startActivity(i)
    }
}