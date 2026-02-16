package com.example.triviaapp.modelo

data class RespuestaDTO(
    var id: String,
    var idUsuario: String,
    var idPregunta: String,
    var idTrivial: String,
    var respuesta: String,
    var correcta: Boolean

)
