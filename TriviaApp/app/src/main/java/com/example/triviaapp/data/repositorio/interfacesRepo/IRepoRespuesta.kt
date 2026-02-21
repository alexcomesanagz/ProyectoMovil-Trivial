package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO

interface IRepoRespuesta {
    fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
    )

    fun crearRespuestas(
        idTrivial: String,
        idUsuario: String,
        idPreguntas: List<PreguntaDTO>,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        respuestaCorrecta: String,
        onSuccess: () -> Unit, onError: () -> Unit
    )
    fun recuento(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (Int) -> Unit,
        onError: () -> Unit
    )
    fun leerTodo(
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit)

}
