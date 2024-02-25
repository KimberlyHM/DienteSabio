package com.example.dientesabio
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.*

class IngresarTest {

    @Test
    fun testInicioWithMock() {
        // Crear un mock de la clase Ingresar
        val ingresarMock = mock(Ingresar::class.java)

        // Mock para EditText y configurar su comportamiento
        val etEmailMock = mock(EditText::class.java)
        val etPassMock = mock(EditText::class.java)
        `when`(ingresarMock.findViewById<EditText>(R.id.et_email)).thenReturn(etEmailMock)
        `when`(ingresarMock.findViewById<EditText>(R.id.et_contra)).thenReturn(etPassMock)
        `when`(etEmailMock.text).thenReturn(mock(Editable::class.java))
        `when`(etPassMock.text).thenReturn(mock(Editable::class.java))
        `when`(etEmailMock.text.toString()).thenReturn("usuario@example.com")
        `when`(etPassMock.text.toString()).thenReturn("contraseña")

        // Mock para Button y configurar su comportamiento
        val buttonMock = mock(Button::class.java)
        `when`(ingresarMock.findViewById<Button>(R.id.btn_ingresar)).thenReturn(buttonMock)

        // Mock para Toast y configurar su comportamiento
        val toastMock = mock(Toast::class.java)
        `when`(Toast.makeText(any(Context::class.java), any(CharSequence::class.java), eq(Toast.LENGTH_SHORT))).thenReturn(toastMock)

        // Configurar el comportamiento del método show de Toast
        `when`(toastMock.show()).thenReturn(Unit)

        // Mock para SharedPreferences y configurar su comportamiento
        val sharedPreferencesMock = mock(SharedPreferences::class.java)
        `when`(ingresarMock.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreferencesMock)

        // Mock para Intent y configurar su comportamiento
        val intentMock = mock(Intent::class.java)
        `when`(ingresarMock.intent).thenReturn(intentMock)

        // Llamar al método que se está probando
        ingresarMock.inicio(buttonMock)

        // Verificar que se llama a startActivity con el intent adecuado
        verify(ingresarMock).startActivity(intentMock)
    }
}