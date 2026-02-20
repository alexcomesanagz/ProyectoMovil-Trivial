package com.example.triviaapp.data.repositorio.reposLocal

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.interfacesRepo.PreferencesRepoInterface
import com.example.triviaapp.modelo.PreferenceDTO

class PreferencesRepo(var context: Context) : PreferencesRepoInterface {
    private var logueado = false

    companion object {
        val NAME_KEY = "name_key";
        val EMAIL_KEY = "email_key";
        val ID_KEY = "id_key";
    }

    override fun getUsuario(): PreferenceDTO? {
        val sp = getSharedPref()

        with(sp) {
            try {
                val id = getString(ID_KEY, "-1")
                val name = getString(NAME_KEY, null)
                val email = getString(EMAIL_KEY, null)

                if (id != "-1" && name != null && email != null) {
                    return PreferenceDTO(id = id!!, nombre = name, correo = email)
                } else {
                    return null
                }
            } catch (e: TypeCastException) {
                e.printStackTrace()
                sp.edit { clear() };
                return null
            }

        }
    }

    override fun registraUsuario(
        usuario: PreferenceDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val sp = getSharedPref()
        with(sp.edit()) {
            putString(ID_KEY, usuario.id)
            putString(NAME_KEY, usuario.nombre)
            putString(EMAIL_KEY, usuario.correo)
            if (commit()) onSuccess() else onError()
        }
    }

    override fun cerrarSesion(
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val sp = getSharedPref()
        with(sp.edit()) {
            clear()
            if (commit()) onSuccess() else onError()
        }
    }


    override fun getSharedPref(): SharedPreferences {
        val sp = context.getSharedPreferences(
            context.getString(R.string.preferences_file),
            Context.MODE_PRIVATE
        )
        return sp
    }
}