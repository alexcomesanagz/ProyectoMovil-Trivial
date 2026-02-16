package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.UsuarioDTO

interface UsuarioRepoInterf {
    fun iniciarSesion(
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO) -> Unit,
        onError: () -> Unit
    )

    fun registrar(
        nombre: String,
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO) -> Unit,
        onError: () -> Unit
    )
}