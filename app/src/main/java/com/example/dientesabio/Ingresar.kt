package com.example.dientesabio

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Ingresar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
    }




    fun inicio (view: View) {
        val etEmail: EditText = findViewById(R.id.et_email)
        val etPass: EditText = findViewById(R.id.et_contra)


        val admin = BaseDatosApp(this, "bd", null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("SELECT EMAIL, PASSWORD FROM Usuarios WHERE EMAIL='${etEmail.text.toString()}' AND PASSWORD='${etPass.text.toString()}'", null)
        var email = ""
        var pass = ""
        if (fila.moveToFirst()){
            email = fila.getString(0)
            pass = fila.getString(1)
        }
        if(etEmail.text.toString()!= "" && etPass.text.toString() != ""){
            if(etEmail.text.toString() == email){
                if(etPass.text.toString() == pass){
                    Toast.makeText(this, "Iniciando sesion.", Toast.LENGTH_SHORT).show()
                    //Ir a otra actividad
                    val intent = Intent(this, Inicio::class.java)
                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this, "El usuario o la contraseña son incorrectos.", Toast.LENGTH_SHORT).show()
            }
        }
        else {Toast.makeText(this, "Debes ingresar un e-mail y una contraseña.", Toast.LENGTH_SHORT).show()}
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