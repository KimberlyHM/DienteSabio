package com.example.dientesabio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dientesabio.controller.AdapterInicio
import com.example.dientesabio.data.InicioTemas

class Inicio : AppCompatActivity() {
    private lateinit var adapterInicio: AdapterInicio
    private lateinit var recycledView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        lateinit var datostema : Inicio
    }

    override fun onStart() {
        super.onStart()
        val layoutManager = LinearLayoutManager(this)
        recycledView = findViewById(R.id.lista_maxilar)
        recycledView.layoutManager = layoutManager
        recycledView.setHasFixedSize(true)
        adapterInicio = AdapterInicio(getTemasList())
        recycledView.adapter = adapterInicio



    }
    fun getTemasList() : ArrayList<InicioTemas>{

        //Array para almacenar las partidas
        val temasList : ArrayList<InicioTemas> = ArrayList()

        //Acceso a la base de datos
        val admin = BaseDatosApp(this, "bd", null, 1)
        val bd = admin.writableDatabase

        //Obtención de registros
        val reg = bd.rawQuery("SELECT ID, NOMBRE, DESCRIPCION FROM InicioTemas", null)

        //Declaración de variables para guardar los datos de la BD
        var id : Int
        var nombre : String
        var descripcion : String
        //var imagen : Int


        //Recorrer la BD y asignar cada registro a una variable
        if (reg.moveToFirst()){
            do {
                id = reg.getString(0).toInt()
                nombre = reg.getString(1)
                descripcion = reg.getString(2)
               // imagen = reg.getString(3).toInt()
                //Agregar variables con valores de la BD al Array que guarda las partidas
                temasList.add(InicioTemas(id, nombre, descripcion))
            } while (reg.moveToNext())
        }
        reg.close()
        return temasList
    }


    fun datos_usuario(view: View){
        val i = Intent(this,Pefil::class.java)
        startActivity(i)
    }

    fun ir_buscar(view: View){
        val i = Intent(this,Buscar::class.java)
        startActivity(i)
    }

    fun inicio(view: View){
        val i = Intent(this,Inicio::class.java)
        startActivity(i)
    }

    fun ir_guardados(view: View){
        val i = Intent(this,Guardados::class.java)
        startActivity(i)
    }
}