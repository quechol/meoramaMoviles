package com.example.memoram

import android.widget.EditText

interface Comunicacion {
    fun menorEdad(edad: Int, nombre: String)
    fun mayorEdad(edad: Int, nombre: String)
    fun regresar()
}