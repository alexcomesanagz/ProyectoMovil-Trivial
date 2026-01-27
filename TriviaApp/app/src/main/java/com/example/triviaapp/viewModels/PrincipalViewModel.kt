package com.example.triviaapp.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.componentes.Tarjeta

class PrincipalViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PrincipalUiState())
    val uiState: StateFlow<PrincipalUiState> = _uiState.asStateFlow()

}

data class PrincipalUiState(
    val tarjetasLista1: List<Tarjeta> = listOf<Tarjeta>(),
    val tarjetasLista2: List<Tarjeta> = listOf<Tarjeta>(),
)