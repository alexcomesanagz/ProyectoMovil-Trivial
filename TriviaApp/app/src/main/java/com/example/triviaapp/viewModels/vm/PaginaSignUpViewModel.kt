package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.viewModels.Uis.PaginaSignUpUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaSignUpViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(PaginaSignUpUi())
    val uiState: StateFlow<PaginaSignUpUi> = _uiState.asStateFlow()

    fun setCorreo(correo : String): String{
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    fun setnombre(nombre : String): String{
        _uiState.value = _uiState.value.copy(nombreUsuario = nombre)
        return _uiState.value.stringCorreo
    }

    fun setContrasena(contrasena : String): String{
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }


}