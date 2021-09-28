package com.example.memoram.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.memoram.Comunicacion
import com.example.memoram.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment2 : Fragment() {
    private lateinit var comunicacion: Comunicacion
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var puntuacion: Int = 0
    var aciertos: Int = 0

    var img0: ImageButton? = null
    var img1: ImageButton? = null
    var img2: ImageButton? = null
    var img3: ImageButton? = null
    var img4: ImageButton? = null
    var img5: ImageButton? = null
    var img6: ImageButton? = null
    var img7: ImageButton? = null
    var img8: ImageButton? = null
    var img9: ImageButton? = null
    var img10: ImageButton? = null
    var img11: ImageButton? = null
    var img12: ImageButton? = null
    var img13: ImageButton? = null
    var img14: ImageButton? = null
    var img15: ImageButton? = null

    //val reiniciar: Button? = null
    //var salir: Button? = null

    //ImageButton[] tablero = new ImageButton[16];
    val buttons: Array<ImageButton?> = arrayOf(img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15)

    //Imagenes
    val imagenes: IntArray = intArrayOf(R.drawable.la0,
        R.drawable.la1,
        R.drawable.la2,
        R.drawable.la3,
        R.drawable.la4,
        R.drawable.la5,
        R.drawable.la6,
        R.drawable.la7)
    //ArrayList
    //val fondo: R.drawable.fondo
    var listDesordenada: List<Int> = ArrayList()
    //ImageButton: primero
    var txtPuntuacion: TextView? = null
    var mov1: Int = 0
    var mov2: Int = 0
    var bloqueo: Boolean = false

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
        val vista = inflater.inflate(R.layout.fragment_fragment2, container, false)

        img0 = vista.findViewById(R.id.img0)
        img1 = vista.findViewById(R.id.img1)
        img2 = vista.findViewById(R.id.img2)
        img3 = vista.findViewById(R.id.img3)
        img4 = vista.findViewById(R.id.img4)
        img5 = vista.findViewById(R.id.img5)
        img6 = vista.findViewById(R.id.img6)
        img7 = vista.findViewById(R.id.img7)
        img8 = vista.findViewById(R.id.img8)
        img9 = vista.findViewById(R.id.img9)
        img10 = vista.findViewById(R.id.img10)
        img11 = vista.findViewById(R.id.img11)
        img12 = vista.findViewById(R.id.img12)
        img13 = vista.findViewById(R.id.img13)
        img14 = vista.findViewById(R.id.img14)
        img15 = vista.findViewById(R.id.img15)

        buttons[0] = img0
        buttons[1] = img1
        buttons[2] = img2
        buttons[3] = img3
        buttons[4] = img4
        buttons[5] = img5
        buttons[6] = img6
        buttons[7] = img7
        buttons[8] = img8
        buttons[9] = img9
        buttons[10] = img10
        buttons[11] = img11
        buttons[12] = img12
        buttons[13] = img13
        buttons[14] = img14
        buttons[15] = img15

        var reiniciar = vista.findViewById<Button>(R.id.btnReiniciar)
        var salir = vista.findViewById<Button>(R.id.btnSalir)

        txtPuntuacion = vista.findViewById(R.id.txtPuntuacion)
        //txtPuntuacion.setText("Puntuacion: $puntuacion")

        listDesordenada = ordenar(imagenes.size)

        for (i in 0..15){
            buttons[i]!!.setScaleType(ImageView.ScaleType.CENTER_CROP)
            //buttons[i]?.setImageResource(imagenes[listDesordenada[i]])
            buttons[i]?.setImageResource(R.drawable.fondo)
        }

        reiniciar.setOnClickListener{

        }
        salir.setOnClickListener{
            //comunicacion.regresar()
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
         * @return A new instance of fragment fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun ordenar(tam: Int): ArrayList<Int> {
        var resultado = ArrayList<Int>()
        for (num in 0..((tam*2)-1)){
            resultado.add(num % tam)
        }
        //Collections.shuffle(resultado)
        return resultado
    }
}