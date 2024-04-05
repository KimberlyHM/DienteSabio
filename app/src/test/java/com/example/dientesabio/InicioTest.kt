package com.example.dientesabio
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dientesabio.controller.AdapterInicio
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InicioTest {

    private lateinit var inicio: Inicio

    @Mock
    private lateinit var mockRecyclerView: RecyclerView

    @Mock
    private lateinit var mockAdapterInicio: AdapterInicio

    @Before
    fun setup() {
        inicio = Inicio()
        inicio.recycledView = mockRecyclerView
        inicio.adapterInicio = mockAdapterInicio
    }

    @Test
    fun testInicio() {
        val contextMock = mock(Context::class.java)
        val viewMock = mock(View::class.java)
        `when`(viewMock.context).thenReturn(contextMock)
        val intentMock = mock(Intent::class.java)

        inicio.inicio(viewMock)

        verify(contextMock).startActivity(intentMock)
    }

    @Test
    fun testDatosUsuario() {
        val viewMock = mock(View::class.java)
        val intentMock = mock(Intent::class.java)

        inicio.datos_usuario(viewMock)

        // Verificar que se llame a startActivity() con el intent correcto
        verify(viewMock.context).startActivity(intentMock)
    }







        @Test
        fun testGetTemasList() {
            // Mock de la base de datos
            val mockAdmin = mock(BaseDatosApp::class.java)
            val mockBd = mock(SQLiteDatabase::class.java)
            `when`(mockAdmin.writableDatabase).thenReturn(mockBd)

            // Mock de los resultados de la consulta
            val mockCursor = mock(Cursor::class.java)
            `when`(mockBd.rawQuery("SELECT ID, NOMBRE, DESCRIPCION, IMAGEN FROM InicioTemas", null))
                .thenReturn(mockCursor)
            `when`(mockCursor.moveToFirst()).thenReturn(true, false)
            `when`(mockCursor.getString(0)).thenReturn("1")
            `when`(mockCursor.getString(1)).thenReturn("Tema de prueba")
            `when`(mockCursor.getString(2)).thenReturn("Descripción de prueba")
            `when`(mockCursor.getString(3)).thenReturn("123")

            // Crear instancia de Inicio y llamar al método
            val inicio = Inicio()
            val temasList = inicio.getTemasList()

            // Verificar que la lista se ha creado correctamente
            assertEquals(1, temasList.size)
            assertEquals("Tema de prueba", temasList[0].nombre)
            assertEquals("Descripción de prueba", temasList[0].descripcion)
            assertEquals(123, temasList[0].imagen)
        }
}


