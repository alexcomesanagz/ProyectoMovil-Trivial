package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.data.repositorio.interfacesRepo.TrivialRepoInterface
import com.example.triviaapp.modelo.TrivialDTO


class TrivialRepo : TrivialRepoInterface {
    private val datos = arrayListOf(
        TrivialDTO(id = "1", idCreador = "1", nombre = "wana", categoria = "Terror"),
        TrivialDTO(id = "2", idCreador = "1", nombre = "nana", categoria = "Accion"),
    )

    override fun obtenerTrivialsPersona(
        idCreador: String,
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    ) {
        var Trivials = datos.filter { it.idCreador == idCreador }
        if (Trivials.isEmpty()) {
            onError(Trivials)
        }
        onSuccess(Trivials)
    }

    override fun crearTrivia(
        idCreador: String,
        nombre: String,
        categoria: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    ) {
        datos.add(
            TrivialDTO(
                id = "${datos.size + 1}",
                idCreador = idCreador,
                nombre = nombre,
                categoria = categoria
            )
        )
        onSuccess(datos.find { it.id == "${datos.size}" }!!)
    }

    override fun borrar(idTrivia: String, onSuccess: () -> Unit, onError: () -> Unit) {
        val trivia = datos.find { it.id == idTrivia }
        datos.remove(trivia)
        onSuccess()
    }

    override fun leerTodo(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: () -> Unit
    ) {
        onSuccess(datos.toList())

    }

    override fun obtenerTrivial(
        idTrivial: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    ) {
       onSuccess(datos.find { it.id == idTrivial }!!)
    }

//    companion object{
//        val preguntas() = ArrayList<PreguntaDTO>(
//            listOf(
//                PreguntaDTO(),
//                PreguntaDTO(),
//                PreguntaDTO(),
//                PreguntaDTO()
//            ))
//            var currId = 1;
//    }

    //crud

}