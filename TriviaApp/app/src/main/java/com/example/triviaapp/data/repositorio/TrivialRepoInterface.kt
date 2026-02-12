package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.TrivialDTO

interface TrivialRepoInterface {
    fun obtenerTrivialsPersona(idCreador: String, onSuccess: () -> Unit, onError: () -> Unit): List<TrivialDTO>
    fun registrar(idCreador: String, nombre: String, categoria: String, onSuccess: (TrivialDTO) -> Unit, onError: () -> Unit)
    fun borrar(idTrivia: String, onSuccess: () -> Unit, onError: () -> Unit)

    }