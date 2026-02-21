package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoRespuesta
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO

class RespuestaRepo : IRepoRespuesta {
    private val respuestas = arrayListOf<RespuestaDTO>()

    override fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        var respuestasTrivial = respuestas.filter { it.idTrivial == idTrivial
                && it.idUsuario == idUsuario }
        if (respuestasTrivial.isEmpty()) {
            onError()
            return
        }
        onSuccess(respuestasTrivial)
    }

    override fun crearRespuestas(
        idTrivial: String,
        idUsuario: String,
        idPreguntas: List<PreguntaDTO>,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        idPreguntas.forEach {
        respuestas.add(
                RespuestaDTO(
                    id = "${respuestas.size + 1}",
                    idTrivial = idTrivial,
                    idUsuario = idUsuario,
                    idPregunta = it.id,
                    respuesta = "1",
                    respuestaCorrecta = it.respuestaCorrecta,
                    correcta = it.respuestaCorrecta=="1"
                )
            )
        }
        onSuccess()
    }

    override fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        respuestaCorrecta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val respuestaLista= respuestas.find {
            it.idTrivial==idTrivial &&
            it.idUsuario==idUsuario &&
            it.idPregunta==idPregunta
        }
        if(respuestaLista!=null){
            val index = respuestas.indexOfFirst { it.id == respuestaLista.id }
            if (index != -1) {
                respuestaLista.respuesta=respuesta
                respuestaLista.respuestaCorrecta=respuestaCorrecta
                respuestaLista.correcta=respuestaCorrecta==respuesta
                respuestas[index] = respuestaLista
                onSuccess()
            }
        }
        else onError()

    }

    override fun recuento(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (Int) -> Unit,
        onError: () -> Unit
    ) {
        var correctas=0
        val listabuena = respuestas.filter {
            it.idTrivial==idTrivial
            && it.idUsuario==idUsuario
        }

        listabuena.forEach {it->
            if(it.correcta)correctas++
        }
        onSuccess(correctas)
    }

    override fun leerTodo(
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
        ) {
        onSuccess(respuestas.toList())
    }


}