package com.example.triviaapp.data.repositorio

import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofit
import com.example.triviaapp.modelo.UsuarioDTO

class UsuarioRepoRemoto(private val api : InterfazRetrofit) : UsuarioRepoInterf {
    override fun iniciarSesion(
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun registrar(
        nombre: String,
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }
}