package com.example.appalkemy.interfaceUsuario.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appalkemy.data.Pelicula
import com.example.appalkemy.databinding.ItemPeliculaBinding
import com.example.appalkemy.nucleo.ViewHolderBase

class PeliculaAdapter(
    private val listaPeliculas: List<Pelicula>,
    private val itemClickListener: PeliculaClickListener
) : RecyclerView.Adapter<ViewHolderBase<*>>() {

    interface PeliculaClickListener {
        fun clickPelicula(pelicula: Pelicula)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBase<*> {
        val itemBinding =
            ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PeliculasViewHolder(itemBinding, parent.context)
        itemBinding.root.setOnClickListener {
            val posicion =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.clickPelicula(listaPeliculas[posicion])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolderBase<*>, position: Int) {
        when (holder) {
            is PeliculasViewHolder -> holder.bindeo(listaPeliculas[position])
        }
    }

    override fun getItemCount(): Int = listaPeliculas.size

    private inner class PeliculasViewHolder(
        val binding: ItemPeliculaBinding,
        val context: Context
    ) : ViewHolderBase<Pelicula>(binding.root) {
        override fun bindeo(item: Pelicula) {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
                .centerCrop().into(binding.ivPortada)
        }
    }
}