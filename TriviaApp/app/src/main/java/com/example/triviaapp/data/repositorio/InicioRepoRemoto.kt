package com.example.triviaapp.data.repositorio


import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.InicioDTO
import com.example.triviaapp.modelo.TrivialDTO

class InicioRepoRemoto(private val api : InterfazRetrofitTrivias) : InicioRepoInterface {
    override fun obtenerRecomendadosPersona(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun anadirRecientes(
        reciente: InicioDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun obtenerRecientesPersona(
        idCreador: String,
        onSuccess: (List<InicioDTO>) -> Unit,
        onError: (List<InicioDTO>) -> Unit
    ) {
        TODO("Not yet implemented")
    }
}