package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaAjustesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaAjustesUi())
    val uiState: StateFlow<PaginaAjustesUi> = _uiState.asStateFlow()

    fun guardarAjustesConNuevoId():String {
        return ""
    }
    fun setCategoria(categoria: String): String{
        _uiState.value = _uiState.value.copy(categoria = categoria)
        return categoria
    }

    fun setNombreTrivia(nombre: String): String{
        _uiState.value = _uiState.value.copy(nombreTriv = nombre)
        return nombre
    }

    fun setPreguntas(numPreguntas: Float): Float{
        _uiState.value = _uiState.value.copy(preguntas = numPreguntas.toInt())
        return _uiState.value.preguntas.toFloat()
    }

}






