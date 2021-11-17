package com.example.estudiando.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.estudiando.Listas
import com.example.estudiando.databinding.FragmentViewBinding



class viewFragment : Fragment() {
    private var _binding: FragmentViewBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentViewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accionBtn1()
        accionBtn2()
        accionBtn3()

    }

    private fun accionBtn1() {
        binding.btn1.setOnClickListener {
            //Acción boton 1
            val lista = Listas()
            binding.txtDescripcion.setText("La lista con los valores :\n ${lista.unsortedList} ,\nse ordenara de forma descendente")
            val listaInvertida = lista.unsortedList.sortedBy { -it }
            binding.txtResultado.setText("$listaInvertida")
        }
    }

    private fun accionBtn2() {
        binding.btn2.setOnClickListener {
            //Acción boton 2
            val lista = Listas()
            binding.txtDescripcion.setText("De los valores \n ${lista.numbersList},\n se elegirá un valor al azar ")
            val listaRandom = lista.numbersList.random()
            binding.txtResultado.setText("$listaRandom")
        }
    }

    private fun accionBtn3() {
        binding.btn3.setOnClickListener {
            //Acción boton 3
            val lista = Listas()
            binding.txtDescripcion.setText("Estos valores se multiplicaran por 5 : \n ${lista.unsortedList}")
            val porCinco = lista.unsortedList.map { it * 5 }
            binding.txtResultado.setText("$porCinco")
        }
    }

}