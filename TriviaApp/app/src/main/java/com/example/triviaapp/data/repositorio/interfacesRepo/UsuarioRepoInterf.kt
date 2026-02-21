package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.UsuarioDTO

interface UsuarioRepoInterf {

    /**
     * inicia sesion del usuario si el nombre y contraseña coinciden
     */
    fun iniciarSesion(
        nombre: String,
        contasena: String,
        onSuccess: (UsuarioDTO?) -> Unit,
        onError: () -> Unit
    )

    /**
     * crea e inicia sesion de un usuario si no existia ya un usuario con ese nombre
     */
    fun registrar(
        nombre: String,
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO?) -> Unit,
        onError: () -> Unit
    )
}