package com.example.appalkemy.interfaceUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.appalkemy.R
import com.example.appalkemy.databinding.FragmentPrincipalBinding


class FragmentPrincipal : Fragment(R.layout.fragment_principal) {
    private lateinit var binding:FragmentPrincipalBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPrincipalBinding.bind(view)
    }
}