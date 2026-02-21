package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.TrivialDTO

interface TrivialRepoInterface {
    /**
     * obtiene todos los trivials de una persona
     * @param idCreador la persona
     */
    fun obtenerTrivialsPersona(
        idCreador: String,
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    )

    /**
     * obtiene todos los trivials de una persona
     * @param idCreador la persona que lo creo
     * @param nombre nombre del trivial
     * @param categoria categoria del trivial
     */
    fun crearTrivia(
        idCreador: String,
        nombre: String,
        categoria: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    )

    /**
     * obtiene todos los trivials de una persona
     * @param idTrivia id del trivia a borrar
     */
    fun borrar(
        idTrivia: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * devuelve todos los trivials
     */
    fun leerTodo(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: () -> Unit)

    /**
     * obtiene todos los trivials de una persona
     * @param idTrivia el trivia que se quiere buscar
     */
    fun obtenerTrivial(
        idTrivia: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit)

}