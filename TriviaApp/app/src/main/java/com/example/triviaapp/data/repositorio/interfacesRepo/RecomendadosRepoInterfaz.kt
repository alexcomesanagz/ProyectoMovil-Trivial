package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.RecomendadosDTO

interface RecomendadosRepoInterfaz {
    fun obtenerRecomendadosPersona(
        onSuccess: (List<RecomendadosDTO>) -> Unit,
        onError: (List<RecomendadosDTO>) -> Unit
    )
}