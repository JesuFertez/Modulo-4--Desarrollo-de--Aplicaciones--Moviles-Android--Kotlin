package com.example.probandokotlin

fun main (){
    val numbers = listOf(1,2,3,-4,5,-6)
    val anyNegative = numbers.any { it <0 }
    val anyGT6 = numbers.any { it > 6 }

    println ("any negative: $anyNegative, anyGT6: $anyGT6")
}