package com.example.appalkemy.interfaceUsuario

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.appalkemy.R
import com.example.appalkemy.data.Pelicula
import com.example.appalkemy.data.PeliculaDataSource
import com.example.appalkemy.databinding.FragmentPrincipalBinding
import com.example.appalkemy.interfaceUsuario.adapters.PeliculaAdapter
import com.example.appalkemy.interfaceUsuario.adapters.PeliculasConcatAdapter
import com.example.appalkemy.nucleo.Recursos
import com.example.appalkemy.presentacion.PeliculaViewModel
import com.example.appalkemy.presentacion.PeliculaViewModelFactory
import com.example.appalkemy.repositorio.ClienteRetrofit
import com.example.appalkemy.repositorio.PeliculaRepositorioImpl


class FragmentPrincipal : Fragment(R.layout.fragment_principal),PeliculaAdapter.PeliculaClickListener {
    private lateinit var binding:FragmentPrincipalBinding
    private val viewModel by viewModels<PeliculaViewModel> { PeliculaViewModelFactory(PeliculaRepositorioImpl(
                                        PeliculaDataSource(ClienteRetrofit.webservice))) }
    private lateinit var concatAdapter: ConcatAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPrincipalBinding.bind(view)
        concatAdapter= ConcatAdapter()
        viewModel.buscarPeliculasPopulares().observe(viewLifecycleOwner, Observer {resultado ->
            when(resultado){
                is Recursos.carga ->{
                    binding.barraProgreso.visibility = View.VISIBLE
                }
                is Recursos.exito ->{
                    binding.barraProgreso.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0,PeliculasConcatAdapter(PeliculaAdapter(resultado.dato.results,this@FragmentPrincipal)))
                    }
                    binding.rvPrincipal.adapter = concatAdapter
                }
                is Recursos.fallo ->{
                    binding.barraProgreso.visibility = View.GONE
                    Log.d("Error","${resultado.excepcion}")
                }
            }

        })
    }

    override fun clickPelicula(pelicula: Pelicula) {
        val accion = FragmentPrincipalDirections.actionFragmentPrincipalToFragmentDetalle(pelicula.poster_path,
            pelicula.backdrop_path,
            pelicula.original_language.toFloat(),
        pelicula.vote_count,
            pelicula.overview,
            pelicula.title,
            pelicula.release_date,
            pelicula.vote_average.toString(),
            )
        findNavController().navigate(accion)
    }
}