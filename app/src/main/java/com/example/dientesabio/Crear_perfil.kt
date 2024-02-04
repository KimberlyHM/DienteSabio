package com.example.dientesabio

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class Crear_perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_perfil)

        val nombre = findViewById<EditText>(R.id.et_nombre)
        val email = findViewById<EditText>(R.id.et_email)
        val pass1 = findViewById<EditText>(R.id.et_contra)
        val pass2 = findViewById<EditText>(R.id.et_contra2)
        val btnAgregarUsuario = findViewById<Button>(R.id.btn_agregar_usuario)

        btnAgregarUsuario.setOnClickListener{

            val admin = BaseDatosApp(this, "bd", null, 1)
            val bd = admin.writableDatabase
            val reg = ContentValues()

            reg.put("NOMBRE", nombre.text.toString())
            reg.put("EMAIL", email.text.toString())
            if(pass1.text.toString() == pass2.text.toString()) {

                reg.put("PASSWORD", pass1.text.toString())
                Toast.makeText(
                    this,
                    "¡El usuario se ha agregado correctamente!",
                    Toast.LENGTH_SHORT
                ).show()


                bd.insert("Usuarios", null, reg)
                bd.close()

                nombre.setText("")
                email.setText("")
                pass1.setText("")
                pass2.setText("")

                val intent = Intent(this, Elegir_perfil::class.java)
                startActivity(intent)
            }
            else{Toast.makeText(
                this,
                "¡Las contraseñas no coinciden!",
                Toast.LENGTH_SHORT
            ).show()}
        }

    }



}



