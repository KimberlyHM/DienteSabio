package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Ingresar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
    }


    fun inicio(view: View){
        val i = Intent(this,Inicio::class.java)
        startActivity(i)
    }

    fun olvido_contra(view: View){
        val i = Intent(this,Olvido_contrasenya::class.java)
        startActivity(i)
    }

    fun main(view: View){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }




}