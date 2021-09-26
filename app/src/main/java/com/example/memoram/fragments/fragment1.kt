package com.example.memoram.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.memoram.Comunicacion
import com.example.memoram.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment1 : Fragment() {
    private lateinit var comunicacion: Comunicacion
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_fragment1, container, false)
        this.comunicacion = activity as Comunicacion

        val btnA: Button = vista.findViewById<Button>(R.id.btnAceptar)
        val edad: EditText = vista.findViewById(R.id.textoEdad)
        //val edad = txtedad
        btnA.setOnClickListener {
            //print("Boton Aceptar")
            //comunicacion.enviarDatos(edad.text.toString().toInt())
            if(edad.text.toString().toInt() <= 17){
                //Menor de edad
                comunicacion.menorEdad(edad.text.toString().toInt())
            }else{
                comunicacion.mayorEdad(edad.text.toString().toInt())
            }
        }
        return vista
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}