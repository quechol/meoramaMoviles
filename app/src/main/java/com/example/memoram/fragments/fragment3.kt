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
import com.example.memoram.Carta
import com.example.memoram.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment3 : Fragment() {
    private lateinit var comunicacion: Comunicacion
    var txtRcbEdad:Int? = 0
    var txtRcbNombre:String? =""
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var buttons: List<ImageButton>
    private lateinit var cards: List<Carta>
    private var indexOfSingleSelectedCard : Int? = null

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
        val vista = inflater.inflate(R.layout.fragment_fragment3, container, false)

        txtRcbEdad = arguments?.getInt("edad")
        txtRcbNombre = arguments?.getString("nombre")

        vista.findViewById<TextView>(R.id.encabezado).text = "Nombre: " +txtRcbNombre + " Edad:" + txtRcbEdad

        var reiniciar = vista.findViewById<Button>(R.id.btnReiniciar)
        var salir = vista.findViewById<Button>(R.id.btnSalir)

        var img0: ImageButton = vista.findViewById(R.id.img0)
        var img1: ImageButton = vista.findViewById(R.id.img1)
        var img2: ImageButton = vista.findViewById(R.id.img2)
        var img3: ImageButton = vista.findViewById(R.id.img3)
        var img4: ImageButton = vista.findViewById(R.id.img4)
        var img5: ImageButton = vista.findViewById(R.id.img5)
        var img6: ImageButton = vista.findViewById(R.id.img6)
        var img7: ImageButton = vista.findViewById(R.id.img7)
        var img8: ImageButton = vista.findViewById(R.id.img8)
        var img9: ImageButton = vista.findViewById(R.id.img9)
        var img10: ImageButton = vista.findViewById(R.id.img10)
        var img11: ImageButton = vista.findViewById(R.id.img11)
        var img12: ImageButton = vista.findViewById(R.id.img12)
        var img13: ImageButton = vista.findViewById(R.id.img13)
        var img14: ImageButton = vista.findViewById(R.id.img14)
        var img15: ImageButton = vista.findViewById(R.id.img15)

        val images = mutableListOf(R.drawable.la00, R.drawable.la10, R.drawable.la20,
            R.drawable.la30, R.drawable.la40, R.drawable.la50, R.drawable.la60, R.drawable.la70)
        images.addAll(images)
        images.shuffle()

        buttons = listOf(img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15)

        cards = buttons.indices.map { index ->
            Carta(images[index], false, false)
        }

        buttons.forEachIndexed{index, button ->
            button.setOnClickListener{
                updateModels(index)
                updateViews()

            }

        }

        reiniciar.setOnClickListener{
            //comunicacion.regresar()
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
         * @return A new instance of fragment fragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun updateModels(index: Int) {
        val card = cards[index]
        if(card.up){
            //Toast.makeText(this, "Movimiento no válido", Toast.LENGTH_SHORT).show()
            return
        }
        if(indexOfSingleSelectedCard == null){
            restorePosition()
            indexOfSingleSelectedCard = index
        }else{
            checkForPair(indexOfSingleSelectedCard!!, index)
            indexOfSingleSelectedCard = null
        }
        card.up = !card.up
    }

    private fun restorePosition() {
        for(card in cards){
            if(!card.found){
                card.up = false
            }
        }
    }

    private fun updateViews() {
        cards.forEachIndexed { index, card ->
            val button = buttons[index]
            if (card.up) {
                button.setImageResource(card.id)
            } else {
                button.setImageResource(R.drawable.fondo)
            }
        }
    }

    private fun checkForPair(index1: Int, index2: Int) {
        if(cards[index1].id == cards[index2].id){
            //Toast.makeText(this, "Pareja encontrada!", Toast.LENGTH_SHORT).show()
            cards[index1].found = true
            cards[index2].found = true
        }
    }
}