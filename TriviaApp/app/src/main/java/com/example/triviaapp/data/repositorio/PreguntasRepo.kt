package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO

class PreguntasRepo : IRepoPregunta {
    private val preguntas = listOf(
        PreguntaDTO(
            id = "1",
            idTrivial = "1",
            opcion1 = "Brasil",
            opcion2 = "Francia",
            opcion3 = "España",
            opcion4 = "Alemania",
            pregunta = "País que gano el mundial en 2010",
            respuestaCorrecta = 3
        ),
        PreguntaDTO(
            id = "2",
            idTrivial = "1",
            opcion1 = "Jesus Navas",
            opcion2 = "Hugo Mallo",
            opcion3 = "Lucas Pérez",
            opcion4 = "Iago Aspas",
            pregunta = "Jugador conocido como \"El príncipe de las bateas\"",
            respuestaCorrecta = 4
        ), PreguntaDTO(
            id = "1",
            idTrivial = "2",
            opcion1 = "Estrela",
            opcion2 = "Pedro",
            opcion3 = "Jose",
            opcion4 = "Marta",
            pregunta = "Mejor profe de 2º DAM (todos son muy buenos profesores)",
            respuestaCorrecta = 2
        ),
        PreguntaDTO(
            id = "2",
            idTrivial = "2",
            opcion1 = "Estrela",
            opcion2 = "Juan",
            opcion3 = "Jose",
            opcion4 = "Pedro",
            pregunta = "Profesor que da la materia denominada como \"Diseño de interfaces\"",
            respuestaCorrecta = 1
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

    override fun leerTodo(onSuccess: (List<PreguntaDTO>) -> Unit, onError: () -> Unit) {
        onSuccess(preguntas)
    }

    companion object
}