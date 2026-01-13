package com.example.triviaapp.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.paginas.PaginaLista
import com.example.triviaapp.paginas.tarjetasUsuario
import kotlinx.coroutines.launch

class PaginaListaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaListaUiState())
    val uiState: StateFlow<PaginaListaUiState> = _uiState.asStateFlow()

}

data class PaginaListaUiState(
    val mapaDatos: Map<String, List<Tarjeta>> = mapOf<String,List<Tarjeta>>(),
)