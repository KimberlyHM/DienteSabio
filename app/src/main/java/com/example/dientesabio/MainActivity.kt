package com.example.dientesabio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageView = findViewById<ImageView>(R.id.im_inicio)

        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.animacion_imagen)
        imageView.startAnimation(animacion2)


        val btn_1 = findViewById<Button>(R.id.btn_ingresar)
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.subir)
        btn_1.startAnimation(animacion1)

        val btn_2 = findViewById<Button>(R.id.btn_registrar)
        val animacion3 = AnimationUtils.loadAnimation(this, R.anim.subir)
        btn_2.startAnimation(animacion3)
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
