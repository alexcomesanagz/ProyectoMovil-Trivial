package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO

interface IRepoRespuesta {
    /**
     *obtiene las respuestas de un trivial de un usuario
     * @param idTrivial el trivial del que se quieren buscar las respuestas
     * @param idUsuario
     */
    fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
    )

    /**
     *crea respuestas para cada pregunta de un trivia, cada usuario puede tener sus propias respuestas
     * @param idTrivial el trivial del que se crearan las respueastas
     * @param idUsuario para quien se van a crear
     * @param idPreguntas las preguntas para las que se van a crear las respuestas
     */
    fun crearRespuestas(
        idTrivial: String,
        idUsuario: String,
        idPreguntas: List<PreguntaDTO>,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     *cambia el comtenido de una respuesta por otro
     * @param idTrivial el trivial al que pertenece la respuesta
     * @param idUsuario el usuario al que pertenece la respuesta
     * @param idPregunta la pregunta a la que pertenece la respuesta
     * @param respuesta respuesta seleccionada por el usuario
     * @param respuestaCorrecta la respuesta que sería la correcta
     */
    fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        respuestaCorrecta: String,
        onSuccess: () -> Unit, onError: () -> Unit
    )

    /**
     *devuelve el numero de respuestas acertadas
     * @param idTrivial el trivial al que pertenecen las respuestas
     * @param idUsuario
     */
    fun recuento(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (Int) -> Unit,
        onError: () -> Unit
    )
}
