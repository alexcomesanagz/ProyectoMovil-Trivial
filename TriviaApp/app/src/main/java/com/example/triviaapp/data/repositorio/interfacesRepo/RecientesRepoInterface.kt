package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.RecientesDTO

interface RecientesRepoInterface {
    /**
     * añade un trivia al que se a accedido para contestar
     *      y lo añade a la pagina principal del usuario
     *@param reciente la informacion que se va a guardar, contiene id del trivia, nombre y categoria
     */
    fun anadirReciente(
        reciente: RecientesDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    )

    /**
     * obtiene todos los trivia que el usuario intentase hacer
     *@param idCreador la id del usuarion en cuestion, se buscan mediante esto
     */
    fun obtenerRecientesPersona(
        idCreador: String,
        onSuccess: (List<RecientesDTO>) -> Unit,
        onError: (List<RecientesDTO>) -> Unit
    )

}