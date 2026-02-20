package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.data.repositorio.reposLocal.UsuarioRepoGeneral
import com.example.triviaapp.modelo.PreferenceDTO
import com.example.triviaapp.viewModels.Uis.PaginaLoginUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaLoginViewModel(application: Application) : AndroidViewModel(application)  {

    private val _uiState = MutableStateFlow(PaginaLoginUi())
    val uiState: StateFlow<PaginaLoginUi> = _uiState.asStateFlow()
    val repoUsuarios = UsuarioRepoGeneral.repo
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)
    fun setCorreo(correo: String): String {
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    fun logIn(onSucces: () -> Unit,onError: ()->Unit) {
        repoUsuarios.iniciarSesion(
            correo = uiState.value.stringCorreo,
            contasena = uiState.value.stringContrasena,
            onSuccess = { it->
                usuarioActual.registraUsuario(
                    usuario = PreferenceDTO(
                        id = it.id,
                        nombre = it.nombre,
                        correo = it.correo

                    ),
                    onSuccess = {onSucces()},
                    onError = onError
                )

            },
            onError = onError)

    }

    fun setVisibilidad() {
        _uiState.value = _uiState.value.copy(contrasenaVisible = !uiState.value.contrasenaVisible)
    }


    fun setContrasena(contrasena: String): String {
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }


}