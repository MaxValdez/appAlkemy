package com.example.appalkemy.nucleo

import java.lang.Exception

sealed class Recursos<out T> {

    class carga<out T>: Recursos<T>()
    data class exito <out T>(val dato: T):Recursos<T>()
    data class fallo(val excepcion: Exception):Recursos<Nothing>()
}