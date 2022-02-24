package com.example.appalkemy.interfaceUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.appalkemy.R
import com.example.appalkemy.databinding.FragmentDetalleBinding


class FragmentDetalle : Fragment(R.layout.fragment_detalle) {
    private lateinit var binding:FragmentDetalleBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentDetalleBinding.bind(view)
    }
}