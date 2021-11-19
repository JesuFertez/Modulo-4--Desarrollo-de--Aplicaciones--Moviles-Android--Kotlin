package com.example.probandokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


fun main(){
   var LibrosEscolares = Libros("17354836-0","Leyendo con Pepito",2017,"Que pasa",140,
   12000,"Pantillana",Formato.IMPRESO)

    var LibrosEscolares2 = Libros("17647996-0","Matemáticas con Pepito",2017,"Que pasa",113,
   11400,"Pantillana",Formato.IMPRESO)

    var LibrosEscolares3 = Libros("17687209-0","Inglés con Pepito",2017,"Que pasa",200,
   10300,"Pantillana",Formato.IMPRESO)

    val LibrosEscolares4 = Libros("17622245-0","Pepito y las Ciencias",2017,"Que pasa",150,
   4000,"Pantillana",Formato.DIGITAL)



    print(LibrosEscolares.toString())
    println()
    print(LibrosEscolares2)
    println()
    print(LibrosEscolares3)
    println()
    print(LibrosEscolares4)



}

fun precioFormateado(precio:Int){
    println("El precio del libro es $ $precio ")
}
