package com.example.triviaapp.data.repositorio.interfacesRepo

import android.content.SharedPreferences
import com.example.triviaapp.modelo.PreferenceDTO

interface PreferencesRepoInterface {
    /**
     * cierra la sesion del usuario
     */
    fun cerrarSesion(
    onSuccess: () -> Unit,
    onError: () -> Unit
    )

    /**
     * registra la informacion del usuario pasado
     */
    fun registraUsuario(usuario: PreferenceDTO,
    onSuccess: () -> Unit,
    onError: () -> Unit
    )

    /**
     * obtiene al usuario
     */
    fun getUsuario(): PreferenceDTO?

    /**
     * obtiene las preferencias
     */
    fun getSharedPref(): SharedPreferences


}