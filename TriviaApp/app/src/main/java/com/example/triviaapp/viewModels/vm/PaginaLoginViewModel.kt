package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.data.repositorio.LogueadoRepo
import com.example.triviaapp.data.repositorio.UsuarioRepo
import com.example.triviaapp.viewModels.Uis.PaginaLoginUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaLoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaLoginUi())
    val uiState: StateFlow<PaginaLoginUi> = _uiState.asStateFlow()
    val repoUsuarios = UsuarioRepo()
    val usuarioLogueado = LogueadoRepo()
    fun setCorreo(correo: String): String {
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    fun logIn(correo: String, contrasena: String, onSucces: () -> Unit) {
        repoUsuarios.obtener(
            correo = correo,
            contasena = contrasena,
            onSuccess = { it ->
                usuarioLogueado.registraUsuario(it,
                    onSuccess = {},
                    onError = {}
                )
                onSucces()
            },
            onError = {})

    }

    fun setVisibilidad() {
        _uiState.value = _uiState.value.copy(contrasenaVisible = !uiState.value.contrasenaVisible)
    }


    fun setContrasena(contrasena: String): String {
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }


}