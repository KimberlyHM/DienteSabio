package com.example.dientesabio
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner





@RunWith(MockitoJUnitRunner::class)
class InicioTest {

        @Mock
        lateinit var mockInicio: Inicio


        @Before
        fun setUp() {
            mockInicio = Inicio()
        }




    @Test
    fun testInicio() {
        // Mock del contexto y del intent
        val viewMock = mock(View::class.java)
        val intentMock = mock(Intent::class.java)

        // Crear una instancia de Inicio y llamar al método inicio()
        val inicio = Inicio()
        inicio.inicio(viewMock)

        // Verificar que se llame a startActivity() con el intent correcto
        verify(viewMock.context).startActivity(intentMock)
    }


     @Test
     fun testDatosUsuarioa() {
        // Mock del contexto y del intent
        val viewMock = mock(View::class.java)
        val intentMock = mock(Intent::class.java)

        // Crear una instancia de Inicio y llamar al método datos_usuario()
        val inicio = Inicio()
        inicio.datos_usuario(viewMock)

        // Verificar que se llame a startActivity() con el intent correcto
        verify(viewMock.context).startActivity(intentMock)
    }



    @Test
    fun testGetTemasList() {
        // Crear un mock de la base de datos
        val baseDatosMock = mock(BaseDatosApp::class.java)

        // Crear un mock del cursor que devuelve la consulta a la base de datos
        val cursorMock = mock(Cursor::class.java)
        `when`(cursorMock.moveToFirst()).thenReturn(true)
        `when`(cursorMock.getString(0)).thenReturn("1")
        `when`(cursorMock.getString(1)).thenReturn("Tema 1")
        `when`(cursorMock.getString(2)).thenReturn("Descripción del tema 1")
        `when`(cursorMock.getString(3)).thenReturn("imagen_tema_1")

        // Configurar el comportamiento del mock de la base de datos
        `when`(baseDatosMock.writableDatabase).thenReturn(mock(SQLiteDatabase::class.java))
        `when`(baseDatosMock.writableDatabase.rawQuery("SELECT ID, NOMBRE, DESCRIPCION, IMAGEN FROM InicioTemas", null)).thenReturn(cursorMock)

        // Crear una instancia de la clase Inicio
        val inicio = Inicio()

        // Llamar al método que queremos probar y pasarle el mock de la base de datos
        val result = inicio.getTemasList()

        // Verificar que el resultado no sea nulo y tenga el tamaño esperado
        assertNotNull(result)
        assertEquals(1, result.size)
    }





}


