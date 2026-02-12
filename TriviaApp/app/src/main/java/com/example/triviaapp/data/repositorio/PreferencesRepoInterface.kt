package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.PreferenceDTO

interface PreferencesRepoInterface {
    fun cerrarSesion( onSuccess: () -> Unit, onError: () -> Unit)
    fun registraUsuario(usuario: PreferenceDTO, onSuccess: () -> Unit, onError: () -> Unit)
    fun getUsuario(): PreferenceDTO?

    }