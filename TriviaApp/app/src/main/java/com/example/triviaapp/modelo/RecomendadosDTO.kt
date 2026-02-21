package com.example.triviaapp.modelo

/**
 * trivias que se recomiendan a todos los usuarios
 * @param idTrivia id del trivia
 * @param nombre nombre del trivia
 * @param categoria categoria del trivia
 */
class RecomendadosDTO (
    val id:String="",
    val idTrivia:String,
    var nombre: String,
    var categoria: String
)