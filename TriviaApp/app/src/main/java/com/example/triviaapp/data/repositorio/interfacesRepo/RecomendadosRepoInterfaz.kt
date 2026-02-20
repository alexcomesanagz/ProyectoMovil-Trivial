package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.RecomendadosDTO

interface RecomendadosRepoInterfaz {
    fun obtenerRecomendados(
        onSuccess: (List<RecomendadosDTO>) -> Unit,
        onError: (List<RecomendadosDTO>) -> Unit
    )
}