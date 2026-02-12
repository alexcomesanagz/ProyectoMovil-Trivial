package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.PreferenceDTO

object PreferencesLogueadoRepo {
    val repo = PreferencesRepo()
}
class PreferencesRepo {
    private var logueado = false
    private var usuario = PreferenceDTO()
    fun getLogueado(): Boolean{
        return logueado
    }

    fun getUsuario(): String{
        return usuario.id
    }
    fun registraUsuario(usuario: PreferenceDTO, onSuccess: () -> Unit, onError: () -> Unit){
        this.logueado = true
        this.usuario = usuario
        onSuccess()
    }

    fun cerrarSesion( onSuccess: () -> Unit, onError: () -> Unit){
        this.logueado=false
        this.usuario= PreferenceDTO()
        onSuccess()
        onError()

    }
}