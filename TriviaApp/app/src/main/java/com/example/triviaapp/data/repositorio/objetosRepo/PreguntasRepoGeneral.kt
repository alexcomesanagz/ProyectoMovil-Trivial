package com.example.triviaapp.data.repositorio.objetosRepo

import com.example.triviaapp.data.repositorio.reposLocal.PreguntasRepo
import com.example.triviaapp.data.repositorio.reposRetrofit.PreguntasRepoRemoto
import com.example.triviaapp.data.repositorio.retrofit.Network

object PreguntasRepoGeneral {
    val repo = PreguntasRepoRemoto(Network.preguntaRetrofit)
}