package com.modulocuatro.kotlin.registroconsumo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.modulocuatro.kotlin.registroconsumo.R
import com.modulocuatro.kotlin.registroconsumo.data.RegistroDB
import com.modulocuatro.kotlin.registroconsumo.databinding.FragmentSecondBinding


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

            saveRegistro()
        }
    }

    private fun saveRegistro() {


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}