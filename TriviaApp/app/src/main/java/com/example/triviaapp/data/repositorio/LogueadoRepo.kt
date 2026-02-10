package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.UsuarioDTO

class LogueadoRepo {
    private var logueado = false
    private var usuario = UsuarioDTO(
        "",
        1,
        "",
        "",
        ""
    )
    fun getLogueado(): Boolean{
        return logueado
    }

    fun getUsuario(): UsuarioDTO{
        return usuario
    }
    fun registraUsuario(usuario: UsuarioDTO?, onSuccess: () -> Unit, onError: () -> Unit){
        this.logueado = true
        this.usuario = usuario!!
        onSuccess()
    }

    fun cerrarSesion( onSuccess: () -> Unit, onError: () -> Unit){
        this.logueado=false
        this.usuario=UsuarioDTO(
            "",
            1,
            "",
            "",
            "")
        onSuccess()
        onError()

    }
}