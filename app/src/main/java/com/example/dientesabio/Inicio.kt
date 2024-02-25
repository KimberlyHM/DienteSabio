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
    lateinit var recycledView: RecyclerView

    //para guardar los temas
    //lateinit var datosTemas: InicioTemas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //datosTemas = intent.getParcelableExtra("datosTemas")!!
    }

    override fun onStart() {
        super.onStart()
        val layoutManager = LinearLayoutManager(this)
        recycledView = findViewById(R.id.lista_maxilar)
        recycledView.layoutManager = layoutManager
        recycledView.setHasFixedSize(true)
        adapterInicio = AdapterInicio(getTemasList())
        recycledView.adapter = adapterInicio


        adapterInicio.onItemClick= {
            val intent = Intent (this, InicioDetalle::class.java).apply{}

            intent.putExtra("datosTemas", it)
            startActivity(intent)
        }

    }
    fun getTemasList() : ArrayList<InicioTemas>{


        val temasList : ArrayList<InicioTemas> = ArrayList()

        //Acceso a la base de datos
        val admin = BaseDatosApp(this, "bd", null, 1)
        val bd = admin.writableDatabase


        val reg = bd.rawQuery("SELECT ID, NOMBRE, DESCRIPCION, IMAGEN FROM InicioTemas", null)


        var id : Int
        var nombre : String
        var descripcion : String
        var imagen : Int


        //Recorrer la BD y asignar cada registro a una variable
        if (reg.moveToFirst()){
            do {
                id = reg.getString(0).toInt()
                nombre = reg.getString(1)
                descripcion = reg.getString(2)
                imagen = reg.getString(3).toInt()

                temasList.add(InicioTemas(id, nombre, descripcion,imagen))
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