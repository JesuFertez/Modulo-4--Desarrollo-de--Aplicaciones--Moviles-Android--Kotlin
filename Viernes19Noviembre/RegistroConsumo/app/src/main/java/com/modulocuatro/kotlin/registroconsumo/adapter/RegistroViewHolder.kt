package com.modulocuatro.kotlin.registroconsumo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.modulocuatro.kotlin.registroconsumo.data.RegistroEntity
import com.modulocuatro.kotlin.registroconsumo.databinding.ItemLayoutBinding

class RegistroViewHolder (
    private val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
//Le paso el layout de los item (la vista que implementara el recycler)
{
      fun bombombum(registro :RegistroEntity) {
          binding.run {
              tvNombreItemRecycler.text = registro.nombreItem
              tvCantidadRecycler.text= registro.cantidad.toString()
              tvPrecioRecycler.text = registro.precioUnidad.toString()
          }
      }
}
