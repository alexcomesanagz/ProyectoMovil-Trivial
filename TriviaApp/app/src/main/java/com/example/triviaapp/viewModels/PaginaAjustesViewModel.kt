package com.example.triviaapp.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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




data class PaginaAjustesUi(
   val nombreTriv:String="",
    val categoria: String="1",
    val muestraCreador: Boolean=false,
    val preguntas: Float=0f,

)

