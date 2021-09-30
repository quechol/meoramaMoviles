package com.example.memoram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memoram.fragments.*

class MainActivity : AppCompatActivity(), Comunicacion {
    override fun onCreate(savedInstanceState: Bundle?) {
        print("Inicio de la aplicacion")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmento1 =  fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.contenedor_frags,fragmento1).commit()
    }

    override fun menorEdad(edad: Int, nombre: String){
        //if (edad <= 18)
        val fragmento2 = fragment2()
        val bundle:Bundle = Bundle()
        bundle.putInt("edad",edad)
        bundle.putString("nombre", nombre)
        val transaction = this.supportFragmentManager.beginTransaction()
        fragmento2.arguments = bundle
        transaction.replace(R.id.contenedor_frags, fragmento2).commit()
    }

    override fun mayorEdad(edad: Int, nombre: String) {
        val fragmento3 = fragment3()
        val bundle:Bundle = Bundle()
        bundle.putInt("edad",edad)
        bundle.putString("nombre", nombre)
        val transaction = this.supportFragmentManager.beginTransaction()
        fragmento3.arguments = bundle
        transaction.replace(R.id.contenedor_frags, fragmento3).commit()
    }

    override fun regresar() {
        val fragmento1 = fragment1()
        val bundle:Bundle = Bundle()
        val transaction = this.supportFragmentManager.beginTransaction()
        fragmento1.arguments = bundle
        transaction.replace(R.id.contenedor_frags, fragmento1).commit()
    }

    override fun victoria(){
        val fragmento4 = fragment4()
        val bundle:Bundle = Bundle()
        val transaction = this.supportFragmentManager.beginTransaction()
        fragmento4.arguments = bundle
        transaction.replace(R.id.contenedor_frags, fragmento4).commit()
    }

    override fun derrota() {
        val fragmento5 = fragment5()
        val bundle:Bundle = Bundle()
        val transaction = this.supportFragmentManager.beginTransaction()
        fragmento5.arguments = bundle
        transaction.replace(R.id.contenedor_frags, fragmento5).commit()
    }
}