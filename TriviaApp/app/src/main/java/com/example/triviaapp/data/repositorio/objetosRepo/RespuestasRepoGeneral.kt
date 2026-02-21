package com.example.triviaapp.data.repositorio.objetosRepo

import com.example.triviaapp.data.repositorio.reposLocal.RespuestaRepo
import com.example.triviaapp.data.repositorio.reposRetrofit.RespuestaRepoRemoto
import com.example.triviaapp.data.repositorio.retrofit.Network

object RespuestasRepoGeneral{
    val repo= RespuestaRepoRemoto(Network.respuestaRetrofit)
}