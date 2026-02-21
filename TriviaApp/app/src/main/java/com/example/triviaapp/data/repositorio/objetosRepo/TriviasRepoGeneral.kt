package com.example.triviaapp.data.repositorio.objetosRepo

import com.example.triviaapp.data.repositorio.reposLocal.TrivialRepo
import com.example.triviaapp.data.repositorio.reposRetrofit.TrivialRepoRemoto
import com.example.triviaapp.data.repositorio.retrofit.Network

object TriviasRepoGeneral {
    val repo = TrivialRepoRemoto(Network.triviaRetrofit)
}
