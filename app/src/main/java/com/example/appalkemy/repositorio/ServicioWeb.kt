package com.example.appalkemy.repositorio

import com.example.appalkemy.data.ListaPeliculas
import com.example.appalkemy.utilidades.Constantes
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicioWeb {
    @GET("movie/popular")
    suspend fun peliculasPopulares(@Query("api_key") apiKey:String): ListaPeliculas
}

object ClienteRetrofit{
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ServicioWeb::class.java)
    }
}