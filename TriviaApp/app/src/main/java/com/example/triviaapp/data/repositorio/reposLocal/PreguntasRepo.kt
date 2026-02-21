package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoPregunta
import com.example.triviaapp.modelo.PreguntaDTO


class PreguntasRepo : IRepoPregunta {
    private val preguntas = arrayListOf<PreguntaDTO>(
        PreguntaDTO(
            id = "1",
            idTrivial = "1",
            opcion1 = "Brasil",
            opcion2 = "Francia",
            opcion3 = "España",
            opcion4 = "Alemania",
            pregunta = "País que gano el mundial en 2010",
            respuestaCorrecta = "3"
        ),
        PreguntaDTO(
            id = "2",
            idTrivial = "1",
            opcion1 = "Jesus Navas",
            opcion2 = "Hugo Mallo",
            opcion3 = "Lucas Pérez",
            opcion4 = "Iago Aspas",
            pregunta = "Jugador conocido como \"El príncipe de las bateas\"",
            respuestaCorrecta = "4"
        ), PreguntaDTO(
            id = "3",
            idTrivial = "2",
            opcion1 = "Estrela",
            opcion2 = "Pedro",
            opcion3 = "Jose",
            opcion4 = "Marta",
            pregunta = "Mejor profe de 2º DAM (todos son muy buenos profesores)",
            respuestaCorrecta = "2"
        ),
        PreguntaDTO(
            id = "4",
            idTrivial = "2",
            opcion1 = "Estrela",
            opcion2 = "Juan",
            opcion3 = "Jose",
            opcion4 = "Pedro",
            pregunta = "Profesor que da la materia denominada como \"Diseño de interfaces\"",
            respuestaCorrecta = "1"
        )
    )

    override fun obtenerPreguntasTrivial(
        idTrivial: String,
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        var preguntasTrivial = preguntas.filter { it.idTrivial == idTrivial }
        if (preguntasTrivial.isEmpty()) {
            onError()
            return
        }
        onSuccess(preguntasTrivial)
    }

    override fun obtenerPregunta(
        idPregunta: String,
        idTrivial: String,
        onSuccess: (PreguntaDTO?) -> Unit,
        onError: () -> Unit
    ) {
        var pregunta = preguntas.find { it.id == idPregunta; it.idTrivial == idTrivial }
        if (pregunta == null) {
            onError()
            return
        }
        onSuccess(preguntas.find { it.id == idPregunta; it.idTrivial == idTrivial })
    }

    override fun crearPreguntas(
        idTrivial: String,
        numPreg: Int,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        repeat(numPreg) {
            preguntas.add(
                PreguntaDTO(
                    id = "${preguntas.size + 1}",
                    idTrivial = idTrivial,
                    opcion1 = "",
                    opcion2 = "",
                    opcion3 = "",
                    opcion4 = "",
                    pregunta = "",
                    respuestaCorrecta = "1"
                )
            )
        }
        onSuccess()
    }

    override fun borrarPreguntas(
        idTrivial: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val lista = preguntas.filter { it.idTrivial == idTrivial }
        lista.forEach { it ->
            preguntas.remove(it)
        }
        onSuccess()
    }

    override fun cambiaDatosPregunta(
        pregunta: PreguntaDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val preguntaLista = preguntas.find { it.id == pregunta.id }
        if (preguntaLista != null) {
            val index = preguntas.indexOfFirst { it.id == pregunta.id }
            if (index != -1) {
                preguntaLista.cambioValores(pregunta)
                preguntas[index] = preguntaLista
                onSuccess()
            }
        } else onError()

    }


    override fun leerTodo(
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        onSuccess(preguntas)
    }

    companion object
}