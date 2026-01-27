package com.example.triviaapp.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaFinViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaFinUiState())
    val uiState: StateFlow<PaginaFinUiState> = _uiState.asStateFlow()


    //Como hago esto, pq no se si es con un update o como
    fun getPreguntasAcertadas(): Int {
        for(Pregunta preguntas: preguntas){
            if(pregunta.respuestaSeleccionada.equals(pregunta.respuestaCorrecta)){
                preguntasCorrectas++;
            }
        }
        return _uiState.value.preguntasCorrectas
    }

    fun getPreguntasTotales(): Int {
        return _uiState.value.preguntas.size
    }

}

data class PaginaFinUiState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0,
    val preguntasCorrectas: Int = 0
)

data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String ="1"
)