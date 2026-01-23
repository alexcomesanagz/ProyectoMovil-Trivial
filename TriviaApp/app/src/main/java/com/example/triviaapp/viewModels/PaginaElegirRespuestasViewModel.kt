package com.example.triviaapp.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ElegirRespViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ElegirRespUIState())
    val uiState: StateFlow<ElegirRespUIState> = _uiState.asStateFlow()

    fun getPregunta(): Pregunta {
        return _uiState.value.preguntas[getNumPreguntaActual()]
    }

    fun getNumPreguntaActual(): Int {
        return _uiState.value.i
    }

    fun getNumPreguntas(): Int {
        return _uiState.value.preguntas.size
    }

    fun cambiaRespuestaBoton(cadena: String): String {
        getPregunta().botonRespuesta.value=cadena
        return  getPregunta().botonRespuesta.value
    }

    fun cambiaTextoBoton(i: Int ,cadena: String): String {
        getPregunta().textoBotonesRespuestas[i].value=cadena
        return getPregunta().textoBotonesRespuestas[i].value
    }

    fun cambiaPregunta(cadena: String): String {
        getPregunta().pregunta.value= cadena
        return  cadena
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




data class ElegirRespUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0
)

class Pregunta(
    var textoBotonesRespuestas: List<MutableState<String>> =listOf(
        mutableStateOf(""),
        mutableStateOf(""),
        mutableStateOf(""),
        mutableStateOf("")),
    var botonRespuesta: MutableState<String> =mutableStateOf(""),
    var pregunta: MutableState<String> = mutableStateOf("")
)