package com.example.estudiando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.estudiando.Listas
private lateinit var button1: Button
private lateinit var txtDescripcion : TextView
private lateinit var txtResultado : TextView
private lateinit var button2: Button
private lateinit var button3: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtDescripcion= findViewById(R.id.txtDescripcion)
        txtResultado= findViewById(R.id.txtResultado)
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)

        button1.setOnClickListener{
            //Accion de boton 1 ordenara la lista por valores descendentes
            var lista = com.example.estudiando.Listas()
            txtDescripcion.setText("La lista con los valores :\n ${lista.unsortedList} ,\nse ordenara de forma descendente")
            val listaInvertida= lista.unsortedList.sortedBy { -it }
            txtResultado.setText("$listaInvertida")

        }

        button2.setOnClickListener{
            //Accion de boton 2 devuelve un valor al azar
            var lista = Listas()
            txtDescripcion.setText("De los valores \n ${lista.numbersList},\n se elegirá un valor al azar ")
            var listaRandom = lista.numbersList.random()
            txtResultado.setText("$listaRandom")
        }

        button3.setOnClickListener{
            //Accion de boton 3 multiplicar todos los valores por 5

            var lista = Listas()
            txtDescripcion.setText("Estos valores se multiplicaran por 5 : \n ${lista.unsortedList}")
            var porCinco= lista.unsortedList.map {it*5}
            txtResultado.setText("$porCinco")


        }


    }

}


