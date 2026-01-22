package com.example.triviaapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.triviaapp.Repositorio.IRepo
import com.example.triviaapp.Repositorio.RepoLocal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaAjustesViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(PaginaAjustesUiState("Ana"))
    val uiState : StateFlow<PaginaAjustesUiState> = _uiState.asStateFlow()

    private val repo : IRepo = RepoLocal()

    fun prueba(){
        _uiState.value= _uiState.value.copy(name="Ana")
    }


}

data class PaginaAjustesUiState(
    val name : String
)