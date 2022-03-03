package com.example.appalkemy.data

import com.example.appalkemy.repositorio.ServicioWeb
import com.example.appalkemy.utilidades.Constantes

class PeliculaDataSource (private val servicioWeb:ServicioWeb){

    suspend fun peliculasPopulares(): ListaPeliculas {

        return servicioWeb.peliculasPopulares(Constantes.API_KEY)
    }

}