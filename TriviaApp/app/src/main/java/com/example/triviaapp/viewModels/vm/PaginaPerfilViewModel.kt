package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import com.example.triviaapp.viewModels.Uis.PaginaFinUiState
import com.example.triviaapp.viewModels.Uis.PaginaPerfilUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPerfilViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(PaginaPerfilUi())
    val uiState: StateFlow<PaginaPerfilUi> = _uiState.asStateFlow()


    fun cargaDatos() {
        _uiState.value = PaginaPerfilUi(
            nombreUsuario = "Juan Pérez",
            correoUsuario = "juan@gmail.com"
        )
    }

}