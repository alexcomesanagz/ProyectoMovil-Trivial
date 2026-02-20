package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.RespuestaDTO

interface IRepoRespuesta {
    fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    )

    fun obtenerRespuestasCorrectas(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    )

    fun crearRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        esCorrecto: Boolean,
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

    fun obtenerRespuestaSeleccionada(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit):String
}
