package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.InicioRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.PreguntasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.RespuestasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.modelo.InicioDTO
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
    val repoInicial = InicioRepoGeneral.repo


    fun cargar(idTrivia: String) {
        preguntasRepo.obtenerPreguntasTrivial(
            idTrivial = idTrivia,
            onSuccess = { preguntas ->
                repuestasRepo.obtenerRespuestasTrivial(
                    idTrivial = idTrivia,
                    idUsuario = usuarioActual.getUsuario()!!.id,
                    onSuccess = {},
                    onError = {
                        preguntas.forEach { pregunta ->
                            repuestasRepo.crearRespuesta(
                                idTrivial = idTrivia,
                                idUsuario = usuarioActual.getUsuario()!!.id,
                                idPregunta = pregunta.id,
                                onSuccess = {},
                                onError = {}
                            )
                        }
                    },
                )
                _uiState.value = uiState.value.copy(preguntas = preguntas.map { preguntaCopia ->
                    Pregunta(
                        id = preguntaCopia.id,
                        pregunta = preguntaCopia.pregunta,
                        respuestaCorrecta = preguntaCopia.respuestaCorrecta.toString(),
                        respuestaSeleccionada = repuestasRepo.obtenerRespuestaSeleccionada(
                            idTrivial = idTrivia,
                            idUsuario = usuarioActual.getUsuario()!!.id,
                            idPregunta = preguntaCopia.id,
                            onSuccess = {},
                            {}
                        ),
                        textoBotonesRespuestas = listOf(
                            preguntaCopia.opcion1,
                            preguntaCopia.opcion2,
                            preguntaCopia.opcion3,
                            preguntaCopia.opcion4
                        )
                    )
                }
                )
                trivialRepo.obtenerTrivial(
                    idTrivial = idTrivia,
                    onSuccess = { it ->
                        repoInicial.anadirRecientes(
                            reciente = InicioDTO(
                                idUsuario = usuarioActual.getUsuario()!!.id,
                                trivia = it.id
                            ),
                            onSuccess = {},
                            onError = {})
                    },
                    onError = {})
            },
            onError = {}
        )

    }

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
        _uiState.value = _uiState.value.copy(
            preguntas = _uiState.value.preguntas.mapIndexed { id, pregunta ->
                if (id == _uiState.value.i) {
                    pregunta.copy(respuestaSeleccionada = cadena)
                } else pregunta
            }
        )
        return getPregunta().respuestaSeleccionada
    }


    fun siguientePregunta(idTrivia: String) {
        val pregunta = getPregunta()
        preguntasRepo.respuestaCorrecta(
            respuesta = pregunta.respuestaSeleccionada,
            preguntaId = pregunta.id,
            onSuccess = { it ->
                repuestasRepo.cambiaRespuesta(
                    idTrivial = idTrivia,
                    idPregunta = pregunta.id,
                    idUsuario = usuarioActual.getUsuario()!!.id,
                    respuesta = pregunta.respuestaSeleccionada,
                    esCorrecto = it,
                    onSuccess = {
                        _uiState.value = _uiState.value.copy(
                            i =
                                if (_uiState.value.i < _uiState.value.preguntas.lastIndex) _uiState.value.i + 1
                                else _uiState.value.i
                        )
                    },
                    onError = {}
                )
            },
            onError = {}
        )
    }

    fun anteriorPregunta(idTrivia: String) {
        val pregunta = getPregunta()
        preguntasRepo.respuestaCorrecta(
            respuesta = pregunta.respuestaSeleccionada,
            preguntaId = pregunta.id,
            onSuccess = { it ->
                repuestasRepo.cambiaRespuesta(
                    idTrivial = idTrivia,
                    idPregunta = pregunta.id,
                    idUsuario = usuarioActual.getUsuario()!!.id,
                    respuesta = pregunta.respuestaSeleccionada,
                    esCorrecto = it,
                    onSuccess = {
                        _uiState.value = _uiState.value.copy(
                            i =
                                if (_uiState.value.i > 0) _uiState.value.i - 1
                                else _uiState.value.i
                        )
                    },
                    onError = {}
                )
            },
            onError = {}
        )
    }

    fun fin(idTrivia: String, onSuccess: () -> Unit, onError: () -> Unit) {
        val pregunta = getPregunta()
        preguntasRepo.respuestaCorrecta(
            respuesta = pregunta.respuestaSeleccionada,
            preguntaId = pregunta.id,
            onSuccess = { it ->
                repuestasRepo.cambiaRespuesta(
                    idTrivial = idTrivia,
                    idPregunta = pregunta.id,
                    idUsuario = usuarioActual.getUsuario()!!.id,
                    respuesta = pregunta.respuestaSeleccionada,
                    esCorrecto = it,
                    onSuccess = onSuccess,
                    onError = onError
                )
            },
            onError = {}
        )
    }

}




