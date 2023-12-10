package com.example.dientesabio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Politicas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_politicas)
    }

    fun regresar(view: View){
        super.onBackPressed()
    }
}