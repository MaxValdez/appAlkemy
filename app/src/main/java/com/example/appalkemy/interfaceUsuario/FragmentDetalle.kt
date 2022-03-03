package com.example.appalkemy.interfaceUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.appalkemy.R
import com.example.appalkemy.databinding.FragmentDetalleBinding


class FragmentDetalle : Fragment(R.layout.fragment_detalle) {
    private lateinit var binding:FragmentDetalleBinding
    private val args by navArgs<FragmentDetalleArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentDetalleBinding.bind(view)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.posterUrl}").centerCrop().into(binding.ivPelicula)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.imagenFondoUrl}").centerCrop().into(binding.ivFondo)
        binding.tvDescripcion.text = args.resenia
        binding.tvIdioma.text = "lenguaje: ${args.lenguaje}"
        binding.tvRating.text= "${args.votoPromedio} ${args.cantidadVotos} Reseñas"
        binding.tvLanzamiento.text= "Lanzamiento: ${args.lanzamiento}"

    }
}