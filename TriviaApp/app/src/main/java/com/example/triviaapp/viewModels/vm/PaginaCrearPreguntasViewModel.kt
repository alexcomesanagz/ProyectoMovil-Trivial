package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.PreguntasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.viewModels.Uis.CreaPreguntasUIState
import com.example.triviaapp.viewModels.Uis.Pregunta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CrearRespViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CreaPreguntasUIState())
    val uiState: StateFlow<CreaPreguntasUIState> = _uiState.asStateFlow()
    val trivialsRepo = TriviasRepoGeneral.repo

    val preguntasRepo = PreguntasRepoGeneral.repo

    fun cargar(idTrivia: String){
        preguntasRepo.obtenerPreguntasTrivial(idTrivial = idTrivia,
            onSuccess = {
                it-> _uiState.value= uiState.value.copy(preguntas =it.map{ it->
                        Pregunta(
                            id = it.id,
                            pregunta = it.pregunta,
                            respuestaCorrecta = it.respuestaCorrecta.toString(),
                            respuestaSeleccionada = "",
                            textoBotonesRespuestas = listOf(it.opcion1,it.opcion2,it.opcion3,it.opcion4)
                        )
                 }
                )
            },
            onError = {})
    }

    /**
     * obtiene la pregunta en la que se está actualmente
     */
    fun getPregunta(): Pregunta {
        return _uiState.value.preguntas[getNumPreguntaActual()]
    }

    /**
     * obtiene en que pregunta se esta actualmente
     */
    fun getNumPreguntaActual(): Int {
        return _uiState.value.i
    }

    /**
     * obtiene la cantidad de preguntas que hay
     */
    fun getNumPreguntas(): Int {
        return _uiState.value.preguntas.size
    }

    /**
     * cambia la respuesta correcta de la pregunta
     */
    fun cambiaRespuestaCorrecta(cadena: String): String {
        _uiState.value= uiState.value.copy(
            preguntas = uiState.value.preguntas.mapIndexed{
                    id,pregunta ->
                if(id==_uiState.value.i){
                    pregunta.copy(respuestaCorrecta = cadena)
                }else pregunta
            }
        )
        return getPregunta().respuestaCorrecta

    }

    /**
     * cambia el mensaje de la lista seleccionado
     * @param i el mensaje que se quiere cambiar
     */
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

    /**
     * cambia el mensaje de la pregunta
     */
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

    /**
     * cambia a la siguiente pregunta si no es la última, guardando la actual antes
     */
    fun siguientePregunta(idTrivia: String) {
        val pregunta= getPregunta()
        preguntasRepo.cambiaDatosPregunta(pregunta = PreguntaDTO(
            id = pregunta.id,
            idTrivial = idTrivia,
            opcion1 = pregunta.textoBotonesRespuestas[0],
            opcion2 = pregunta.textoBotonesRespuestas[1],
            opcion3 = pregunta.textoBotonesRespuestas[2],
            opcion4 = pregunta.textoBotonesRespuestas[3],
            pregunta = pregunta.pregunta,
            respuestaCorrecta = pregunta.respuestaCorrecta
        ),
            onSuccess = {
                _uiState.value=_uiState.value.copy(i =
                if(_uiState.value.i < _uiState.value.preguntas.lastIndex)_uiState.value.i+1
                else _uiState.value.i)
                        },
            onError = {}
        )

    }

    /**
     * cambia a la anterio pregunta si no es la primera, guardando la actual antes
     */
    fun anteriorPregunta(idTrivia: String) {
        val pregunta= getPregunta()
        preguntasRepo.cambiaDatosPregunta(pregunta = PreguntaDTO(
            id = pregunta.id,
            idTrivial = idTrivia,
            opcion1 = pregunta.textoBotonesRespuestas[0],
            opcion2 = pregunta.textoBotonesRespuestas[1],
            opcion3 = pregunta.textoBotonesRespuestas[2],
            opcion4 = pregunta.textoBotonesRespuestas[3],
            pregunta = pregunta.pregunta,
            respuestaCorrecta = pregunta.respuestaCorrecta
        ),
            onSuccess = {
                _uiState.value=_uiState.value.copy(i =
                if(_uiState.value.i > 0)_uiState.value.i-1
                else _uiState.value.i)
                        },
            onError = {}
        )

    }

    /**
     * guarda la pregunta en la que se acabó el trivial
     */
    fun fin(idtrivial:String,onSuccess: ()-> Unit,onError: ()-> Unit){
        val pregunta= getPregunta()
        preguntasRepo.cambiaDatosPregunta(pregunta = PreguntaDTO(
            id = pregunta.id,
            idTrivial = idtrivial,
            opcion1 = pregunta.textoBotonesRespuestas[0],
            opcion2 = pregunta.textoBotonesRespuestas[1],
            opcion3 = pregunta.textoBotonesRespuestas[2],
            opcion4 = pregunta.textoBotonesRespuestas[3],
            pregunta = pregunta.pregunta,
            respuestaCorrecta = pregunta.respuestaCorrecta
        ),
            onSuccess = onSuccess,
            onError = onError
        )
    }

    /**
     * borra las preguntas y el trivia creados
     */
    fun cancelarCreacion(idTrivia:String, onSucces:()->Unit, onError:()->Unit){
        preguntasRepo.borrarPreguntas(idTrivial = idTrivia, onSuccess = {
            trivialsRepo.borrar(
                idTrivia = idTrivia,
                onSuccess = onSucces,
                onError = onError
            )
        },
        onError = {}
        )
    }

}




