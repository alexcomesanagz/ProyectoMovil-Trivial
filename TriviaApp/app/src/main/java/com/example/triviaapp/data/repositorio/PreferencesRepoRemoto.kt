package com.example.triviaapp.data.repositorio

import android.content.SharedPreferences
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofit
import com.example.triviaapp.modelo.PreferenceDTO

class PreferencesRepoRemoto(private val api : InterfazRetrofit) : PreferencesRepoInterface {
    override fun cerrarSesion(onSuccess: () -> Unit, onError: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun registraUsuario(
        usuario: PreferenceDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getUsuario(): PreferenceDTO? {
        TODO("Not yet implemented")
    }

    override fun getSharedPref(): SharedPreferences {
        TODO("Not yet implemented")
    }
}