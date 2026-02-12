package com.example.triviaapp.data.repositorio

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

    fun leerTodo(onSuccess: (List<PreguntaDTO>) -> Unit, onError: () -> Unit)
}
