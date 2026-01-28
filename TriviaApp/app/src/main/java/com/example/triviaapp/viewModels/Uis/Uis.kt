package com.example.triviaapp.viewModels.Uis

import com.example.triviaapp.R
import com.example.triviaapp.componentes.Tarjeta

data class PaginaAjustesUi(
    val nombreTriv:String="",
    val categoria: String="1",
    val preguntas: Int=0
    )

data class ElegirRespUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0
)

data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String ="1"
)


data class PaginaFinUiState(
    val preguntasAcertadas: Int = 5,
    val preguntasTotales: Int = 10,
    val imagenResultado: Int = R.drawable.trivia
)

data class PaginaListaUiState(
    val mapaDatos: Map<String, List<Tarjeta>> = mapOf<String,List<Tarjeta>>(),
)

data class ResponderPregUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0
)

data class PrincipalUiState(
    val tarjetasLista1: List<Tarjeta> = listOf<Tarjeta>(),
    val tarjetasLista2: List<Tarjeta> = listOf<Tarjeta>(),
)