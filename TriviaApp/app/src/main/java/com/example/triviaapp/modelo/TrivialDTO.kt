package com.example.triviaapp.modelo

/**
 * objeto que representa a un trivia
 * @param idCreador quien creo el trivia
 * @param nombre nombre del trivial
 * @param categoria categoria del trivial
 */
data class TrivialDTO (
    var id: String="",
    var idCreador: String="",
    var nombre: String="",
    var categoria: String=""
)