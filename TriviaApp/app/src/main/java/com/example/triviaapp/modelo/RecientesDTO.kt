package com.example.triviaapp.modelo

/**
 * datos de trivias recientemente intentados
 * @param id
 * @param idUsuario el usuario que intento el trivia
 * @param trivia id del trivia intentado
 * @param nombre nombre del trivia
 * @param categoria categoria del trivia
 */
class RecientesDTO (
    var id:String="",
    var idUsuario : String,
    var trivia: String,
    var nombre: String,
    var categoria: String
)