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
            if (nombre.text.isNotEmpty() && email.text.isNotEmpty() && pass1.text.isNotEmpty() && pass2.text.isNotEmpty()) {

                if(pass1.text.toString() == pass2.text.toString()){
                // Verificar que el correo electrónico tenga un @
                    if ('@' in email.text) {
                        // Verificar si el correo electrónico ya está en la base de datos
                        val admin = BaseDatosApp(this, "bd", null, 1)
                        val bd = admin.readableDatabase
                        val cursor = bd.rawQuery("SELECT * FROM Usuarios WHERE EMAIL=?", arrayOf(email.text.toString()))
                        if (cursor.count == 0) {
                            // El correo electrónico no está en la base de datos, continuar con el registro
                            Toast.makeText(this, "¡El usuario se ha agregado correctamente!", Toast.LENGTH_SHORT).show()
                            val reg = ContentValues()

                            reg.put("NOMBRE", nombre.text.toString())
                            reg.put("EMAIL", email.text.toString())
                            reg.put("PASSWORD", pass1.text.toString())

                            bd.insert("Usuarios", null, reg)
                            bd.close()

                            nombre.setText("")
                            email.setText("")
                            pass1.setText("")


                            val intent = Intent(this, Elegir_perfil::class.java)
                            startActivity(intent)
                        } else {
                            // El correo electrónico ya está en la base de datos
                            Toast.makeText(this, "¡El correo electrónico ya está registrado!", Toast.LENGTH_SHORT).show()
                        }
                        cursor.close()
                    } else {
                        // El correo electrónico no contiene @
                        Toast.makeText(this, "¡El correo electrónico no es válido!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Las contraseñas no coinciden
                    Toast.makeText(this, "¡Las contraseñas no coinciden!", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Al menos uno de los campos está vacío
                Toast.makeText(this, "¡Por favor completa todos los campos!", Toast.LENGTH_SHORT).show()
            }
        }
        }





}



