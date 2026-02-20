package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.TrivialDTO

interface TrivialRepoInterface {
    fun obtenerTrivialsPersona(
        idCreador: String,
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    )

    fun crearTrivia(
        idCreador: String,
        nombre: String,
        categoria: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    )

    fun borrar(
        idTrivia: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun leerTodo(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: () -> Unit)

    fun obtenerTrivial(
        idTrivia: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit)

}