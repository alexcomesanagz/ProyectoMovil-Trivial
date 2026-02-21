package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.PreguntaDTO

interface IRepoPregunta {
    /**
     * obtiene todas las preguntas de un trivial concreto
     *@param idTrivial se utiliza para buscar las preguntas
     */
    fun obtenerPreguntasTrivial(
        idTrivial: String,
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    )

    /**
     * obtiene una pregunta concreta de un trivial
     * @param idPregunta id de la pregunta que se quiere
     * @param idTrivial el trivial de donde es esa pregunta
     */
    fun obtenerPregunta(
        idPregunta: String,
        idTrivial: String,
        onSuccess: (PreguntaDTO?) -> Unit,
        onError: () -> Unit
    )

    /**
     *  crea preguntas de un trivial concreto,
     *  el numero de preguntas que se crea es igual al numero que se le pasa
     *@param idTrivial el trivial para el que se crearan las preguntas
     * @param numPreg numero de preguntas a crear
     */
    fun crearPreguntas(
        idTrivial: String,
        numPreg: Int,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * borra todas las preguntas de un trivia
     * @param idTrivial trivia del que se borraran las preguntas
     */
    fun borrarPreguntas(
        idTrivial: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * cambia los datos de una pregunta concreta
     * @param pregunta la preguntas con los datos cambiados
     */
    fun cambiaDatosPregunta(
        pregunta: PreguntaDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )
}
