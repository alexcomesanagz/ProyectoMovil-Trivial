package com.example.triviaapp.viewModels.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.triviaapp.data.repositorio.UsuarioRepo
import com.example.triviaapp.viewModels.Uis.PaginaSignUpUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaSignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaSignUpUi())
    val uiState: StateFlow<PaginaSignUpUi> = _uiState.asStateFlow()
    val repoUsuarios = UsuarioRepo()

    fun setCorreo(correo: String): String {
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    fun setnombre(nombre: String): String {
        _uiState.value = _uiState.value.copy(nombreUsuario = nombre)
        return _uiState.value.stringCorreo
    }

    fun setContrasena(contrasena: String): String {
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }

    fun registrar() {
        repoUsuarios.registrar(
            nombre = uiState.value.nombreUsuario,
            correo = uiState.value.stringCorreo,
            contasena = uiState.value.stringCorreo,
            {},
            onError = {})
    }


}