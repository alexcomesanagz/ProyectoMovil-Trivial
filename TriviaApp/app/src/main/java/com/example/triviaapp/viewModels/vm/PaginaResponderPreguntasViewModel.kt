package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.viewModels.Uis.Pregunta
import com.example.triviaapp.viewModels.Uis.ResponderPregUIState
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


    fun cambiaRespuestaBoton(cadena: String): String {
        _uiState.value=_uiState.value.copy(
            preguntas = _uiState.value.preguntas.mapIndexed{
            id,pregunta ->
                if(id==_uiState.value.i){
                pregunta.copy(respuestaSeleccionada = cadena)
            }else pregunta
        }
        )
        return getPregunta().respuestaSeleccionada
    }



    fun siguientePregunta() {
        _uiState.value=_uiState.value.copy(i =
        if(_uiState.value.i < _uiState.value.preguntas.lastIndex)_uiState.value.i+1
        else _uiState.value.i)
    }

    fun anteriorPregunta() {
        _uiState.value=_uiState.value.copy(i =
            if(_uiState.value.i > 0)_uiState.value.i-1
            else _uiState.value.i)
    }


}




