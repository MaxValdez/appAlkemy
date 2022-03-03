package com.example.appalkemy.presentacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.appalkemy.nucleo.Recursos
import com.example.appalkemy.repositorio.PeliculaRepositorio
import kotlinx.coroutines.Dispatchers

class PeliculaViewModel(private val repo:PeliculaRepositorio):ViewModel() {

    fun buscarPeliculasPopulares()= liveData(Dispatchers.IO){
        emit(Recursos.carga())
        try {
            emit(Recursos.exito(repo.peliculasPopulares()))
        }catch (e:Exception){
            emit(Recursos.fallo(e))
        }

    }
}

class PeliculaViewModelFactory(private val repo:PeliculaRepositorio):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PeliculaRepositorio::class.java).newInstance(repo)
    }


}