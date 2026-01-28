package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import com.example.triviaapp.viewModels.Uis.PaginaLoginUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaLoginViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(PaginaLoginUi())
    val uiState: StateFlow<PaginaLoginUi> = _uiState.asStateFlow()

    fun setCorreo(correo : String): String{
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    fun setContrasena(contrasena : String): String{
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }


}