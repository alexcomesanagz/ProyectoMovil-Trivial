package com.example.triviaapp.data.repositorio.reposRetrofit

import com.example.triviaapp.data.repositorio.interfacesRepo.TrivialRepoInterface
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.TrivialDTO

class TrivialRepoRemoto(private val triviaRetrofit : InterfazRetrofitTrivias) : TrivialRepoInterface {
    override fun obtenerTrivialsPersona(
        idCreador: String,
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun crearTrivia(
        idCreador: String,
        nombre: String,
        categoria: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun borrar(
        idTrivia: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun leerTodo(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun obtenerTrivial(
        idTrivial: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }
}