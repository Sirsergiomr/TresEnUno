package com.example.tresenuno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculardora.*


class FragmentCalculardora : Fragment() {
    var num1: Double = 0.0
    var num2: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        val rotacion = activity?.windowManager?.defaultDisplay?.rotation
        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
        }else{
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculardora, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

        }
        bt0.setOnClickListener() {
            textView.text = textView.text.toString() + 0.toString()
        }
        bt1.setOnClickListener() {
            textView.text = textView.text.toString() + 1.toString()
        }
        bt2.setOnClickListener() {
            textView.text = textView.text.toString() + 2.toString()
        }
        bt3.setOnClickListener() {
            textView.text = textView.text.toString() + 3.toString()
        }
        bt4.setOnClickListener() {
            textView.text = textView.text.toString() + 4.toString()
        }
        bt5.setOnClickListener() {
            textView.text = textView.text.toString() + 5.toString()
        }
        bt6.setOnClickListener() {
            textView.text = textView.text.toString() + 6.toString()
        }
        bt7.setOnClickListener() {
            textView.text = textView.text.toString() + 7.toString()
        }
        bt8.setOnClickListener() {
            textView.text = textView.text.toString() + 8.toString()
        }
        bt9.setOnClickListener() {
            textView.text = textView.text.toString() + 9.toString()
        }
        button_punto.setOnClickListener(){
            var entrada = textView.getText().toString()
            if (entrada == "") {
                Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
            } else if (entrada.contains('.')) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                button_punto.isEnabled = false
            } else {
                textView.text = textView.text.toString() + "."
            }
        }
        buttonDel.setOnClickListener() {
            button_punto.isEnabled = true
            if (textView.getText().toString() == "") {
                Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
            } else if (textView.getText().toString() == "") {
                Toast.makeText(context, "No se puede borrar si no hay nada", Toast.LENGTH_LONG).show()
            } else {
                borra()
            }
        }
        button_sumar.setOnClickListener() {
            button_punto.isEnabled = true
            if (textView.getText().toString() == "") {
                Toast.makeText(context, "No has puesto nada", Toast.LENGTH_LONG).show()
            } else {
                num1 = textView.getText().toString().toDouble()
                operator = "+"
                textView.text = ""
            }
        }

        button_restas.setOnClickListener() {
            button_punto.isEnabled = true
            if (textView.getText().toString() == "") {
                textView.text = "-"
            } else if (comprueba() == false) {
                num1 = textView.getText().toString().toDouble()
                operator = "-"
                textView.text = ""
            }
        }
        button_multi.setOnClickListener() {
            button_punto.isEnabled = true
            if (textView.getText().toString() == "") {
                Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
            } else if (comprueba() == false) {
                num1 = textView.getText().toString().toDouble()
                operator = "x"
                textView.text = ""
            }
        }
        button_div.setOnClickListener() {
            button_punto.isEnabled = true
            if (textView.getText().toString() == "") {
                Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
            } else if (comprueba() == false) {
                num1 = textView.getText().toString().toDouble()
                operator = "/"
                textView.text = ""
            }
        }
        button_resultado.setOnClickListener() {
            if (textView.getText().toString() == "") {
                textView.text = num1.toString()
            } else if (comprueba() == false) {
                num2 = textView.getText().toString().toDouble()
                if (operator == "+") {

                    textView.text = sincero(sum(num1, num2)).toString()

                }
                if (operator == "-") {
                    textView.text = sincero(rest(num1, num2)).toString()
                }
                if (operator == "x") {
                    textView.text = sincero(multi(num1, num2)).toString()
                }
                if (operator == "/") {
                    if (num2 == 0.0) {
                        Toast.makeText(context, "No se puede dividir entre 0", Toast.LENGTH_LONG).show()
                    } else {

                        textView.text = sincero(divi(num1, num2)).toString()

                    }
                }
            }

            val directions= FragmentCalculardoraDirections.actionFragmentCalculardoraToFragmentResultado(
                Resultado =  textView.getText().toString()
            )
            Navigation.findNavController(it).navigate(directions)
        }
    }
            fun sum(a: Double, b: Double): Double = a + b
            fun rest(a: Double, b: Double): Double = a - b
            fun multi(a: Double, b: Double): Double = a * b
            fun divi(a: Double, b: Double): Double = a / b
            fun sincero(resultado: Double): String? {
                var retorno = ""
                retorno = resultado.toString()
                if (resultado % 1.0 == 0.0) {
                    retorno = retorno.substring(0, retorno.length - 2)
                }
                return retorno
            }

            fun comprueba(): Boolean? {
                var retorno = false
                var c = textView.getText().toString()
                if (c == "-" || c == "-." || c == ".-" || c == ".") {
                    retorno = true
                }
                return retorno
            }

            fun borra() {
                val Vc = ""
                textView.text = Vc
                num1 = 0.0
                num2 = 0.0
            }
        }