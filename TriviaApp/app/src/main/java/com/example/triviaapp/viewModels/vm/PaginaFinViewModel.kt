package com.example.triviaapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import com.example.triviaapp.viewModels.Uis.PaginaFinUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaFinViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaFinUiState())
    val uiState: StateFlow<PaginaFinUiState> = _uiState.asStateFlow()

    fun cambioImagen() {
        _uiState.value = if (_uiState.value.preguntasAcertadas < _uiState.value.preguntasTotales / 2) {
            _uiState.value.copy(imagenResultado = R.drawable.ic_launcher_background)
        } else {
            _uiState.value.copy(imagenResultado = R.drawable.trivia)
        }
    }

    fun cargaDatos() {
        _uiState.value = PaginaFinUiState()
    }

}
