package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.data.repositorio.LogueadoRepo
import com.example.triviaapp.data.repositorio.UsuarioLogueadoRepo
import com.example.triviaapp.data.repositorio.UsuarioRepo
import com.example.triviaapp.data.repositorio.UsuarioRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaLoginUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaLoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaLoginUi())
    val uiState: StateFlow<PaginaLoginUi> = _uiState.asStateFlow()
    val repoUsuarios = UsuarioRepoGeneral.repo
    val usuarioLogueado = UsuarioLogueadoRepo.repo
    fun setCorreo(correo: String): String {
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    fun logIn(onSucces: () -> Unit,onError: ()->Unit) {
        repoUsuarios.obtener(
            correo = uiState.value.stringCorreo,
            contasena = uiState.value.stringContrasena,
            onSuccess = { it->
                usuarioLogueado.registraUsuario(
                    usuario = it,
                    onSuccess = onSucces,
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