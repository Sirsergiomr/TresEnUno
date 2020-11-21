package com.example.tresenuno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_principal.*

class FragmentPrincipal : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonNavegador.setOnClickListener({
            val directions = FragmentPrincipalDirections.actionFragmentPrincipalToFragmentNavegador()
            Navigation.findNavController(it).navigate(directions)
        })
        buttonCamara.setOnClickListener({
            val directions = FragmentPrincipalDirections.actionFragmentPrincipalToFragmentCamara()
            Navigation.findNavController(it).navigate(directions)
        })
        buttonCalculator.setOnClickListener({
            val directions = FragmentPrincipalDirections.actionFragmentPrincipalToFragmentCalculardora()
            Navigation.findNavController(it).navigate(directions)
        })
    }
}