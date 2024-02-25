package com.example.dientesabio

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosApp (context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {

    private val tablaUsuarios = "CREATE TABLE Usuarios" +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NOMBRE TEXT," +
            "EMAIL TEXT," +
            "PASSWORD TEXT)"


    val tablaInicio = "CREATE TABLE InicioTemas" +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NOMBRE TEXT," +
            "DESCRIPCION TEXT," +
            "IMAGEN INTEGER)"

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL(tablaUsuarios)
        database?.execSQL(tablaInicio)
        database?.execSQL(temasPrincipal)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    val temasPrincipal= "INSERT INTO InicioTemas (ID, NOMBRE, DESCRIPCION, IMAGEN) VALUES "+
                    "(1,'Prognatismo','Es una alteración en el crecimiento de la mandíbula, la cual," +
                     " crece más de lo normal; al morder, los dientes inferiores sobresalen mucho más, " +
                    "dando la imagen de un mentón pronunciado. Se detecta en los primeros años de vida, " +
                   " y dependiendo de su gravedad, hay diferentes tratamie ntos: para los pacientes infantiles" +
                   " es preferible la Ortodoncia Interceptiva, que consiste en el uso o de una Mentonera o " +
                   "de una Máscara Facial. Sin embargo, si se quiere tratar en etapa adulta, " +
                   "la mejor opción es una Cirugía Ortognática.', "+R.drawable.prognatismo +" ), " +
                    "(2,'Laterognatia','Surge cuando hay una asimetría en el rostro, producto de una desviación" +
                    " mandibular hacia los lados. Puede ser causada por ATM de los cartílagos y huesos, o de los músculos" +
                    " de la articulación, y dependerá de la causa para sus tratamientos.', "+R.drawable.latetog+ ");"


}

