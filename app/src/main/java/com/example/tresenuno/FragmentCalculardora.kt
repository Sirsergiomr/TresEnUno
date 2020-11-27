package com.example.tresenuno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
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
    fun numbers(v: View) {
        val num = (v.id)
        textView.text = textView.text.toString() + num.toString()
    }

    fun punto(v: View) {
        var entrada = textView.getText().toString()
        var bt13 = R.id.button13
        if (entrada == "") {
            Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (entrada.contains('.')) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            button13.isEnabled = false
        } else {
            textView.text = textView.text.toString() + "."
        }
    }



    fun btSuma(v: View) {
        button13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(context, "No has puesto nada", Toast.LENGTH_LONG).show()
        } else {
            num1 = textView.getText().toString().toDouble()
            operator = "+"
            textView.text = ""
        }
    }

    fun btResta(v: View) {
        button13.isEnabled = true
        if (textView.getText().toString() == "") {
            textView.text = "-"
        } else if (comprueba() == false) {
            num1 = textView.getText().toString().toDouble()
            operator = "-"
            textView.text = ""
        }
    }

    fun btMulti(v: View) {
        button13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (comprueba() == false) {
            num1 = textView.getText().toString().toDouble()
            operator = "x"
            textView.text = ""
        }
    }

    fun btDivi(v: View) {
        button13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (comprueba() == false) {
            num1 = textView.getText().toString().toDouble()
            operator = "/"
            textView.text = ""
        }
    }

    fun btDel(v: View) {
        button13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(context, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (textView.getText().toString() == "") {
            Toast.makeText(context,"No se puede borrar si no hay nada", Toast.LENGTH_LONG).show()
        } else {
            borra()
        }
    }

    fun btEquals(v: View) {
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
                    Toast.makeText(context,"No se puede dividir entre 0", Toast.LENGTH_LONG).show()
                } else {

                        textView.text = sincero(divi(num1, num2)).toString()

                }
            }
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