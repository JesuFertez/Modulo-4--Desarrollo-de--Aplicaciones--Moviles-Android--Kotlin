package com.modulocuatro.kotlin.registroconsumo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.modulocuatro.kotlin.registroconsumo.R
import com.modulocuatro.kotlin.registroconsumo.data.RegistroDB
import com.modulocuatro.kotlin.registroconsumo.data.RegistroDao
import com.modulocuatro.kotlin.registroconsumo.data.RegistroEntity
import com.modulocuatro.kotlin.registroconsumo.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*
import android.widget.Toast.makeText as makeText1


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null


    private val binding get() = _binding!!
    private lateinit var database: RegistroDB


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        activity?.let { safeActivity ->

            database = Room.databaseBuilder(
                safeActivity.application, RegistroDB::class.java, RegistroDB.DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()

            setupNumberPicker()
            saveRegistro()
        }
    }

    private fun saveRegistro() {
        binding.btnGuardar.setOnClickListener {
            binding.run {
                var entradaNombre= edtEntradaNombre.text.toString()
                var entradaPrecio= edtEntradaPrecio.text.toString().toInt()
                var entradaCantidad = numberPicker.value.toString().toInt()
                var totalActual = entradaPrecio*entradaCantidad


                var nuevoRegistro = RegistroEntity(0,entradaNombre,entradaPrecio,entradaCantidad,totalActual)
                database.registroDao.insert(nuevoRegistro)

                edtEntradaNombre.text.clear()
                edtEntradaPrecio.text.clear()
                numberPicker.value=0

            }
              Toast.makeText(context, "Registro guardado con éxito",Toast.LENGTH_SHORT).show()
            Log.d("Lista",database.registroDao.getAllRegistros().toString())
        }
        }

    private fun setupNumberPicker() {
        with(binding.numberPicker){
            minValue = 0
            maxValue = 100
            wrapSelectorWheel = true
            setOnValueChangedListener { _, _, nuevoValor ->
                muestraTotalActual(getPrecio(), nuevoValor)
            }
        }
    }

    private fun muestraTotalActual(precio: Int, nuevoValor: Int) {
        val nuevoTotal = nuevoValor * precio
        binding.tvMuestraTotal.text = (nuevoTotal).toString()
    }

    private fun getPrecio(): Int {
        return try {
            binding.edtEntradaPrecio.text.toString().toInt()
        } catch (exception: NumberFormatException) {
            0
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}