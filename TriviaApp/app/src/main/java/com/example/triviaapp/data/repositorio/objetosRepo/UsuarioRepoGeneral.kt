package com.example.triviaapp.data.repositorio.objetosRepo

import com.example.triviaapp.data.repositorio.reposLocal.UsuarioRepo
import com.example.triviaapp.data.repositorio.reposRetrofit.UsuarioRepoRemoto
import com.example.triviaapp.data.repositorio.retrofit.Network

object UsuarioRepoGeneral {
    val repo = UsuarioRepo()
}
