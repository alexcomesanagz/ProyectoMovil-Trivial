package com.example.triviaapp.data.repositorio.reposRetrofit

import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoRespuesta
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitRespuestas
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.RespuestaDTO

class RespuestaRepoRemoto(private val respuestaRetrofit : InterfazRetrofitRespuestas) : IRepoRespuesta {
    override fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun obtenerRespuestasCorrectas(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun crearRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        esCorrecto: Boolean,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun recuento(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (Int) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun leerTodo(
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun obtenerRespuestaSeleccionada(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ): String {
        TODO("Not yet implemented")
    }
}