package com.example.triviaapp.data.repositorio.objetosRepo

import com.example.triviaapp.data.repositorio.reposRetrofit.RecientesRepoRemoto
import com.example.triviaapp.data.repositorio.retrofit.Network

object RecientesRepoGeneral {
    val repo = RecientesRepoRemoto(Network.recientesRetrofit)
}