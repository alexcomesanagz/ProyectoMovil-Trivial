package com.example.triviaapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.triviaapp.componentes.Tarjeta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaFinViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaFinUiState())
    val uiState: StateFlow<PaginaFinUiState> = _uiState.asStateFlow()

}

data class PaginaFinUiState(
    val preguntasAcertadas: Integer = 0,
    val preguntasTotales: Integer = 10,
)