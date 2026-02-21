package com.example.triviaapp.data.repositorio.objetosRepo

import com.example.triviaapp.data.repositorio.reposLocal.RecomendadosRepo
import com.example.triviaapp.data.repositorio.reposRetrofit.RecomendadosRepoRetrofit
import com.example.triviaapp.data.repositorio.retrofit.Network

object RecomendadosRepoGeneral {
    val repo = RecomendadosRepoRetrofit(Network.recomendadosRetrofit)
}
