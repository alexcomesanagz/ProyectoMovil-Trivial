package com.example.triviaapp.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ResponderPreguntasViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ResponderPregUIState())
    val uiState: StateFlow<ResponderPregUIState> = _uiState.asStateFlow()

    fun getPregunta(): Pregunta {
        return _uiState.value.preguntas[getNumPreguntaActual()]
    }

    fun getNumPreguntaActual(): Int {
        return _uiState.value.i
    }

    fun getNumPreguntas(): Int {
        return _uiState.value.preguntas.size
    }

    fun getRespuestasCorrectas(): Int {
        var i=0
        _uiState.value.preguntas.forEach {
            if(it.respuestaSeleccionada.equals(it.respuestaCorrecta))i++
        }
        return i
    }

    fun cambiaRespuestaBoton(cadena: String): String {
        _uiState.update { state ->
            val preguntasActualizadas = state.preguntas.mapIndexed { idx, pregunta ->
                if (idx == state.i) {
                    pregunta.copy(respuestaSeleccionada = cadena)
                }
                else{pregunta}
            }
            state.copy(preguntas = preguntasActualizadas)
        }
        return getPregunta().respuestaSeleccionada
    }



    fun siguientePregunta() {
        _uiState.update { state ->
            if (state.i < state.preguntas.lastIndex) {
                state.copy(i = state.i + 1)
            } else {
                state
            }
        }
    }

    fun anteriorPregunta() {
        _uiState.update { state ->
            if (state.i > 0) {
                state.copy(i = state.i - 1)
            } else {
                state
            }
        }
    }


}




data class ResponderPregUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0
)
