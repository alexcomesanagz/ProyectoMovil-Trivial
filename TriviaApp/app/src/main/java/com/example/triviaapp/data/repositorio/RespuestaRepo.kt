package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO
object RespuestasRepoGeneral{
    val repo= RespuestaRepo()
}

class RespuestaRepo : IRepoRespuesta {
    private val respuestas = arrayListOf<RespuestaDTO>()

    override fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
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

    override fun obtenerRespuestasCorrectas(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        var respuestasTrivial = respuestas.filter { it.idTrivial == idTrivial
                && it.idUsuario == idUsuario
                && it.correcta}
        if (respuestasTrivial.isEmpty()) {
            onError()
            return
        }
        onSuccess(respuestasTrivial)
    }


    override fun crearRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
            respuestas.add(
                RespuestaDTO(
                    id = "${respuestas.size + 1}",
                    idTrivial = idTrivial,
                    idUsuario = idUsuario,
                    idPregunta = idPregunta,
                    respuesta = "1",
                    correcta = false
                )
            )
        onSuccess()
    }

    override fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        esCorrecto: Boolean,
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
                respuestaLista.correcta=esCorrecto
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

    override fun obtenerRespuestaSeleccionada(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ): String {
        val respuesta = respuestas.find {
            it.idTrivial==idTrivial
            && it.idUsuario==idUsuario
            && it.idPregunta==idPregunta
        }
        if(respuesta!=null)return  respuesta.respuesta
        else return ""
    }

}