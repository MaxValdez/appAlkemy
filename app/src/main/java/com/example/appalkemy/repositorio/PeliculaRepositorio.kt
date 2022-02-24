package com.example.appalkemy.repositorio

import com.example.appalkemy.data.ListaPeliculas

interface PeliculaRepositorio {

    suspend fun peliculasPopulares(): ListaPeliculas
}