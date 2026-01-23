package com.example.triviaapp.viewModels

import android.util.Log
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

    fun cambiaRespuestaCorrecta(cadena: String): String {
        _uiState.update { state ->
            val preguntasActualizadas = state.preguntas.mapIndexed { idx, pregunta ->
                if (idx == state.i) {
                    pregunta.copy(respuestaCorrecta = cadena)
                }
                else{pregunta}
            }
            state.copy(preguntas = preguntasActualizadas)
        }
        return getPregunta().respuestaCorrecta

    }

    fun cambiaTextoBoton(i: Int ,cadena: String): String {
        _uiState.update { state ->
                val preguntasActualizadas = state.preguntas.mapIndexed { idx, pregunta ->
                    if (idx == state.i) {
                        val botonesActualizados = pregunta.textoBotonesRespuestas.mapIndexed { j, texto ->
                            if (j == i) cadena else texto
                        }
                        pregunta.copy(textoBotonesRespuestas = botonesActualizados)
                    } else pregunta
                }
                state.copy(preguntas = preguntasActualizadas)
            }
        return _uiState.value.preguntas[getNumPreguntaActual()].textoBotonesRespuestas[i]

    }

    fun cambiaPregunta(cadena: String): String {
        _uiState.update { state ->
            val preguntasActualizadas = state.preguntas.mapIndexed { idx, pregunta ->
                if (idx == state.i) {
                    pregunta.copy(pregunta = cadena)
                }
                else{pregunta}
            }
            state.copy(preguntas = preguntasActualizadas)
        }
        return _uiState.value.preguntas[getNumPreguntaActual()].pregunta
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

data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String =""
)