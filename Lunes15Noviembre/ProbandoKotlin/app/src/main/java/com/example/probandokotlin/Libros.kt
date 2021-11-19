package com.example.probandokotlin

data class Libros(
    var isbn: String,
    val NombreLibro: String,
    var Añopublicacion: Int,
    var editorial: String,
    var cantidadPaginas: Short,
    var precio: Int,
    var autorLibro: String,
    var formato: Formato
) {

    override fun toString(): String {
        return "Libros(isbn='$isbn'," +
                " NombreLibro='$NombreLibro'," +
                " Añopublicacion=$Añopublicacion," +
                " editorial='$editorial', " +
                "cantidadPaginas=$cantidadPaginas, " +
                "precio = $$precio, " +
                "autorLibro='$autorLibro', " +
                "formato='$formato')"
    }
}
