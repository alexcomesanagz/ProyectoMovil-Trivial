package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.data.repositorio.interfacesRepo.RecomendadosRepoInterfaz
import com.example.triviaapp.modelo.RecomendadosDTO


class RecomendadosRepo : RecomendadosRepoInterfaz {
    private val recomendados = arrayListOf<RecomendadosDTO>()

    override fun obtenerRecomendados(
        onSuccess: (List<RecomendadosDTO>) -> Unit,
        onError: (List<RecomendadosDTO>) -> Unit
    ) {
        onSuccess(recomendados)
    }

}