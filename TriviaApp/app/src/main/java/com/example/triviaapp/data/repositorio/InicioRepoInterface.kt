package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.InicioDTO
import com.example.triviaapp.modelo.TrivialDTO

interface InicioRepoInterface {
    fun obtenerRecomendadosPersona(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    )

    fun anadirRecientes(
        reciente: InicioDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    fun obtenerRecientesPersona(
        idCreador: String,
        onSuccess: (List<InicioDTO>) -> Unit,
        onError: (List<InicioDTO>) -> Unit
    )
}