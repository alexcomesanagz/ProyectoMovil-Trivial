package com.example.triviaapp.modelo

/**
 * objeto que representa la respuesta de un usuario a una pregunta
 * @param idUsuario el usuario que esta respondiendo
 * @param idPregunta pregunta a la que se responde
 * @param idTrivial trivial al que pertenece
 * @param respuesta respuesta del usuario
 * @param respuestaCorrecta respuesta que seria la correcta
 * @param correcta indica si la respuesta seleccionada es la correcta o no
 */
data class RespuestaDTO(
    var id: String="",
    var idUsuario: String,
    var idPregunta: String,
    var idTrivial: String,
    var respuesta: String,
    var respuestaCorrecta: String="",
    var correcta: Boolean

)
