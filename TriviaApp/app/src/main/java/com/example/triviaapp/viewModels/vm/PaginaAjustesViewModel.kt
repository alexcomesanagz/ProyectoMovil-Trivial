package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaAjustesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaAjustesUi())
    val uiState: StateFlow<PaginaAjustesUi> = _uiState.asStateFlow()

//    fun getPregunta(): Pregunta {
//        return _uiState.value.preguntas[getNumPreguntaActual()]
//    }
//
//    fun getNumPreguntaActual(): Int {
//        return _uiState.value.i
//    }
//
//    fun getNumPreguntas(): Int {
//        return _uiState.value.preguntas.size
//    }
//
//    fun cambiaRespuestaCorrecta(cadena: String): String {
//        _uiState.update { state ->
//            val preguntasActualizadas = state.preguntas.mapIndexed { idx, pregunta ->
//                if (idx == state.i) {
//                    pregunta.copy(respuestaCorrecta = cadena)
//                }
//                else{pregunta}
//            }
//            state.copy(preguntas = preguntasActualizadas)
//        }
//        return getPregunta().respuestaCorrecta
//
//    }

}






