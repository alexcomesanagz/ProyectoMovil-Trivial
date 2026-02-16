package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO

interface IRepoPregunta {
    fun obtenerPreguntasTrivial(
        idTrivial: String,
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    )

    fun obtenerPregunta(
        idPregunta: String,
        idTrivial: String,
        onSuccess: (PreguntaDTO?) -> Unit,
        onError: () -> Unit
    )

    fun crearPreguntas(
        idTrivial: String,
        numPreg: Int,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun borrarPreguntas(
        idTrivial: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun cambiaDatosPregunta(
        pregunta: PreguntaDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun respuestaCorrecta(
        respuesta: String,
        preguntaId: String,
        onSuccess: (Boolean) -> Unit,
        onError: () -> Unit
    )

    fun leerTodo(
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    )
}
