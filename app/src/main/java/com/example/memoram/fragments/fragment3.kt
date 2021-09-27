package com.example.memoram.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var puntuacion: Int = 0
    var aciertos: Int = 0

    lateinit var img0: ImageButton
    lateinit var img1: ImageButton
    lateinit var img2: ImageButton
    lateinit var img3: ImageButton
    lateinit var img4: ImageButton
    lateinit var img5: ImageButton
    lateinit var img6: ImageButton
    lateinit var img7: ImageButton
    lateinit var img8: ImageButton
    lateinit var img9: ImageButton
    lateinit var img10: ImageButton
    lateinit var img11: ImageButton
    lateinit var img12: ImageButton
    lateinit var img13: ImageButton
    lateinit var img14: ImageButton
    lateinit var img15: ImageButton

    //ImageButton[] tablero = new ImageButton[16];
    val buttons = arrayOf(img0,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15)
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

        //img1 = vista.findViewById<ImageButton>(R.id.img0)
        //print(buttons[2])

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
}