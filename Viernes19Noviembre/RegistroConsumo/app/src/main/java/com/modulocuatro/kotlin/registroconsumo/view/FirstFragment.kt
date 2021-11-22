package com.modulocuatro.kotlin.registroconsumo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.modulocuatro.kotlin.registroconsumo.R
import com.modulocuatro.kotlin.registroconsumo.adapter.RecyclerAdapter
import com.modulocuatro.kotlin.registroconsumo.data.RegistroDB
import com.modulocuatro.kotlin.registroconsumo.data.RegistroEntity
import com.modulocuatro.kotlin.registroconsumo.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private lateinit var database: RegistroDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        activity?.let { safeActivity ->
            database = Room.databaseBuilder(
                safeActivity.application, RegistroDB::class.java, RegistroDB.DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()
         setupRecyclerView()
        }
    }

    private fun setupRecyclerView() {
        
        context?.let { notNullContext ->
            val adapter = RecyclerAdapter()
            adapter.setRegistroLista(database.registroDao.getAllRegistros()).toString()//
            val layoutManager = LinearLayoutManager(notNullContext)
            binding.run {
                recyclerList.adapter = adapter
                recyclerList.layoutManager = layoutManager
            }
        }
    }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }