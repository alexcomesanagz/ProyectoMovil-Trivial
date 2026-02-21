package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.RecientesRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.PreguntasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.RespuestasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.modelo.RecientesDTO
import com.example.triviaapp.viewModels.Uis.Pregunta
import com.example.triviaapp.viewModels.Uis.ResponderPregUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ResponderPreguntasViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(ResponderPregUIState())
    val uiState: StateFlow<ResponderPregUIState> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext

    val usuarioActual = PreferencesRepo(context!!)
    val preguntasRepo = PreguntasRepoGeneral.repo
    val repuestasRepo = RespuestasRepoGeneral.repo
    val trivialRepo = TriviasRepoGeneral.repo
    val repoInicial = RecientesRepoGeneral.repo

    /**
     * carga las preguntas y añade el trivia al recientes del usuario
     */
    fun cargar(idTrivia: String) {
        trivialRepo.obtenerTrivial(
            idTrivia = idTrivia,
            onSuccess = { it ->
                repoInicial.anadirReciente(
                    reciente = RecientesDTO(
                        idUsuario = usuarioActual.getUsuario()!!.id,
                        trivia = it.id,
                        nombre = it.nombre,
                        categoria = it.categoria
                    ),
                    onSuccess = {},
                    onError = {})
            },
            onError = {}
        )

        preguntasRepo.obtenerPreguntasTrivial(
            idTrivial = idTrivia,
            onSuccess = { preguntas ->
                repuestasRepo.obtenerRespuestasTrivial(
                    idTrivial = idTrivia,
                    idUsuario = usuarioActual.getUsuario()!!.id,
                    onSuccess = { it->
                        _uiState.value = uiState.value.copy(preguntas = preguntas.map { preguntaCopia ->
                            Pregunta(
                                id = preguntaCopia.id,
                                pregunta = preguntaCopia.pregunta,
                                respuestaCorrecta = preguntaCopia.respuestaCorrecta.toString(),
                                respuestaSeleccionada = it.find{ it.idPregunta==preguntaCopia.id }!!.respuesta,
                                textoBotonesRespuestas = listOf(
                                    preguntaCopia.opcion1,
                                    preguntaCopia.opcion2,
                                    preguntaCopia.opcion3,
                                    preguntaCopia.opcion4
                                )
                            )
                        }
                        )

                    },
                    onError = {
                        repuestasRepo.crearRespuestas(
                            idTrivial = idTrivia,
                            idUsuario = usuarioActual.getUsuario()!!.id,
                            idPreguntas = preguntas,
                            onSuccess = {
                                repuestasRepo.obtenerRespuestasTrivial(idTrivial = idTrivia, idUsuario = usuarioActual.getUsuario()!!.id,
                                    {it->
                                        _uiState.value = uiState.value.copy(preguntas = preguntas.map { preguntaCopia ->
                                            Pregunta(
                                                id = preguntaCopia.id,
                                                pregunta = preguntaCopia.pregunta,
                                                respuestaCorrecta = preguntaCopia.respuestaCorrecta.toString(),
                                                respuestaSeleccionada = it.find { it.idPregunta==preguntaCopia.id }!!.respuesta,
                                                textoBotonesRespuestas = listOf(
                                                    preguntaCopia.opcion1,
                                                    preguntaCopia.opcion2,
                                                    preguntaCopia.opcion3,
                                                    preguntaCopia.opcion4
                                                )
                                            )
                                        }
                                        )

                                    },
                                    {})

                            },
                            onError = {}
                        )

                    },
                )


            },
            onError = {}
        )

    }

    /**
     * obtiene la pregunta en la que se está actualmente
     */
    fun getPregunta(): Pregunta {
        return _uiState.value.preguntas[getNumPreguntaActual()]
    }

    /**
     * obtiene el numero de la pregunta en la que se está actualmente
     */
    fun getNumPreguntaActual(): Int {
        return _uiState.value.i
    }

    /**
     * obtiene cuantas preguntas hay en total
     */
    fun getNumPreguntas(): Int {
        return _uiState.value.preguntas.size
    }

    /**
     * cambia la respuesta del usuario
     */
    fun cambiaRespuestaBoton(cadena: String): String {
        _uiState.value = _uiState.value.copy(
            preguntas = _uiState.value.preguntas.mapIndexed { id, pregunta ->
                if (id == _uiState.value.i) {
                    pregunta.copy(respuestaSeleccionada = cadena)
                } else pregunta
            }
        )
        return getPregunta().respuestaSeleccionada
    }

    /**
     * cambia a la siguiente respuesta, pero antes guarda la actual
     */
    fun siguientePregunta(idTrivia: String) {
        val pregunta = getPregunta()
        repuestasRepo.cambiaRespuesta(
            idTrivial = idTrivia,
            idPregunta = pregunta.id,
            idUsuario = usuarioActual.getUsuario()!!.id,
            respuesta = pregunta.respuestaSeleccionada,
            respuestaCorrecta = pregunta.respuestaCorrecta,
            onSuccess = {
                _uiState.value = _uiState.value.copy(
                    i =
                        if (_uiState.value.i < _uiState.value.preguntas.lastIndex) _uiState.value.i + 1
                        else _uiState.value.i
                )
            },
            onError = {})
    }

    /**
     * cambia a la anterior respuesta, pero antes guarda la actual
     */
    fun anteriorPregunta(idTrivia: String) {
        val pregunta = getPregunta()
        repuestasRepo.cambiaRespuesta(
            idTrivial = idTrivia,
            idPregunta = pregunta.id,
            idUsuario = usuarioActual.getUsuario()!!.id,
            respuesta = pregunta.respuestaSeleccionada,
            respuestaCorrecta = pregunta.respuestaCorrecta,
            onSuccess = {
                _uiState.value = _uiState.value.copy(
                    i =
                        if (_uiState.value.i > 0) _uiState.value.i - 1
                        else _uiState.value.i
                )
            },
            onError = {})

    }

    /**
     * acaba el trivia, pero antes guarda la actual
     */
    fun fin(idTrivia: String, onSuccess: () -> Unit, onError: () -> Unit) {
        val pregunta = getPregunta()
        repuestasRepo.cambiaRespuesta(
            idTrivial = idTrivia,
            idPregunta = pregunta.id,
            idUsuario = usuarioActual.getUsuario()!!.id,
            respuesta = pregunta.respuestaSeleccionada,
            respuestaCorrecta = pregunta.respuestaCorrecta,
            onSuccess = onSuccess,
            onError = onError)

    }

}




