package com.example.appalkemy.repositorio

import androidx.lifecycle.ViewModelProvider
import com.example.appalkemy.data.ListaPeliculas
import com.example.appalkemy.data.PeliculaDataSource

class PeliculaRepositorioImpl(private val dataSource:PeliculaDataSource):PeliculaRepositorio {
    override suspend fun peliculasPopulares(): ListaPeliculas = dataSource.peliculasPopulares()
}

