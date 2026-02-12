package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO


class RespuestaRepo : IRepoRespuesta {
    private val respuestas = listOf(
        RespuestaDTO(
            id = "1",
            idTrivial = "1",
            idUsuario = "1",
            idPregunta = "1",
            respuesta = "3",
            correcta = true
        ),
        RespuestaDTO(
            id = "2",
            idTrivial = "1",
            idUsuario = "1",
            idPregunta = "2",
            respuesta = "2",
            correcta = false
        ),
        RespuestaDTO(
            id = "1",
            idTrivial = "1",
            idUsuario = "2",
            idPregunta = "1",
            respuesta = "1",
            correcta = false
        ),
        RespuestaDTO(
            id = "2",
            idTrivial = "1",
            idUsuario = "2",
            idPregunta = "2",
            respuesta = "4",
            correcta = true
        ),
        RespuestaDTO(
            id = "1",
            idTrivial = "2",
            idUsuario = "1",
            idPregunta = "1",
            respuesta = "2",
            correcta = true
        ),
        RespuestaDTO(
            id = "2",
            idTrivial = "2",
            idUsuario = "1",
            idPregunta = "2",
            respuesta = "3",
            correcta = false
        ),
        RespuestaDTO(
            id = "1",
            idTrivial = "2",
            idUsuario = "2",
            idPregunta = "1",
            respuesta = "3",
            correcta = false
        ),
        RespuestaDTO(
            id = "1",
            idTrivial = "2",
            idUsuario = "2",
            idPregunta = "2",
            respuesta = "1",
            correcta = true
        )
    )

    override fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        var respuestasTrivial = respuestas.filter { it.idTrivial == idTrivial
                && it.idUsuario == idUsuario }
        if (respuestasTrivial.isEmpty()) {
            onError()
            return
        }
        onSuccess(respuestasTrivial)
    }

    override fun obtenerRespuestasCorrectas(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        var respuestasTrivial = respuestas.filter { it.idTrivial == idTrivial
                && it.idUsuario == idUsuario
                && it.correcta}
        if (respuestasTrivial.isEmpty()) {
            onError()
            return
        }
        onSuccess(respuestasTrivial)
    }

    override fun leerTodo(onSuccess: (List<RespuestaDTO>) -> Unit, onError: () -> Unit) {
        onSuccess(respuestas)
    }

}