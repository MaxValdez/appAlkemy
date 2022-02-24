package com.example.appalkemy.repositorio

import com.example.appalkemy.data.ListaPeliculas

class PeliculaRepositorioImpl:PeliculaRepositorio {
    override suspend fun peliculasPopulares(): ListaPeliculas {
    return ListaPeliculas()
    }
}