package com.example.triviaapp.modelo

data class RespuestaDTO(
    var id: String,
    var idUsuario: String,
    var idPregunta: String,
    var respuesta: String,
    var correcta: Boolean,
    var idTrivial: String
)
