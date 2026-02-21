package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.PreguntaDTO

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


    fun leerTodo(
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    )
}
