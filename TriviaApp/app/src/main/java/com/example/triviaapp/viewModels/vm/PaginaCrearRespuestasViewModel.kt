package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.data.repositorio.TriviasRepoGeneral
import com.example.triviaapp.viewModels.Uis.ElegirRespUIState
import com.example.triviaapp.viewModels.Uis.Pregunta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CrearRespViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ElegirRespUIState())
    val uiState: StateFlow<ElegirRespUIState> = _uiState.asStateFlow()
    val trivialsRepo = TriviasRepoGeneral.repo

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
        _uiState.value=_uiState.value.copy(
            preguntas = _uiState.value.preguntas.mapIndexed{
                    id,pregunta ->
                if(id==_uiState.value.i){
                    pregunta.copy(respuestaCorrecta = cadena)
                }else pregunta
            }
        )
        return getPregunta().respuestaCorrecta

    }

    fun cambiaTextoBoton(i: Int ,cadena: String): String {
        _uiState.value=_uiState.value.copy(
            preguntas = _uiState.value.preguntas.mapIndexed{
                    id,pregunta ->
                if(id==_uiState.value.i){
                    val botonesActualizados = pregunta.textoBotonesRespuestas.mapIndexed{j, texto ->
                        if (j == i) cadena else texto
                    }
                    pregunta.copy(textoBotonesRespuestas = botonesActualizados)
                }else pregunta
            }
        )

        return _uiState.value.preguntas[getNumPreguntaActual()].textoBotonesRespuestas[i]

    }

    fun cambiaPregunta(cadena: String): String {
        _uiState.value=_uiState.value.copy(
            preguntas = _uiState.value.preguntas.mapIndexed{
                    id,pregunta ->
                if(id==_uiState.value.i){
                    pregunta.copy(pregunta = cadena)
                }else pregunta
            }
        )

        return _uiState.value.preguntas[getNumPreguntaActual()].pregunta
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

    fun cancelarCreacion(idTrivia:String, onSucces:()->Unit, onError:()->Unit){
        trivialsRepo.borrar(
            idTrivia = idTrivia,
            onSuccess = onSucces,
            onError = onError
        )
    }

}




