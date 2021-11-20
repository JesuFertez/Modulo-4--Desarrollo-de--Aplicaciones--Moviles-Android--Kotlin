package com.modulocuatro.kotlin.registroconsumo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.modulocuatro.kotlin.registroconsumo.data.RegistroEntity
import com.modulocuatro.kotlin.registroconsumo.databinding.ItemLayoutBinding

class RecyclerAdapter (): RecyclerView.Adapter<RegistroViewHolder>() {

    private lateinit var registroLista : List <RegistroEntity>

    fun setRegistroLista (registroLista : List<RegistroEntity>){
        this.registroLista = registroLista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistroViewHolder {
        //al binding le asigno el itemLayout e inflo su vista
       val binding: ItemLayoutBinding = ItemLayoutBinding.inflate(
           LayoutInflater.from(parent.context),parent, false)
        return  RegistroViewHolder(binding) //retorno la clase RegistroViewHolder que he creado
    }

    override fun onBindViewHolder(holder: RegistroViewHolder, position: Int) {
        holder.bombombum(registroLista[position])
        //bombombum es el nombre de la funcion de la clase RegistroViewHolder que he creado, esta funcion
        //vincula los input del item layout con los datos de la clase RegistroEntity
    }

    override fun getItemCount(): Int {
        return registroLista.size
    }

}


