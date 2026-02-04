package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.viewModels.Uis.MainUi
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUi())
    val uiState: StateFlow<MainUi> = _uiState.asStateFlow()

    fun quitaTodo(){
        _uiState.value = _uiState.value.copy(scaffold = false, botonFlotante =false )
    }

    fun ponTodo(){
        _uiState.value = _uiState.value.copy(scaffold = true, botonFlotante =true )
    }

    fun quitaBoton(){
        _uiState.value = _uiState.value.copy(botonFlotante =false )
    }




}






