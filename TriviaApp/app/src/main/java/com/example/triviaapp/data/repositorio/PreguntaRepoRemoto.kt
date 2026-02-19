package com.example.triviaapp.data.repositorio


import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.PreguntaDTO

class PreguntaRepoRemoto(private val api : InterfazRetrofitTrivias) : IRepoPregunta {
    override fun obtenerPreguntasTrivial(
        idTrivial: String,
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun obtenerPregunta(
        idPregunta: String,
        idTrivial: String,
        onSuccess: (PreguntaDTO?) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun crearPreguntas(
        idTrivial: String,
        numPreg: Int,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun borrarPreguntas(
        idTrivial: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun cambiaDatosPregunta(
        pregunta: PreguntaDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun respuestaCorrecta(
        respuesta: String,
        preguntaId: String,
        onSuccess: (Boolean) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun leerTodo(
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }
}