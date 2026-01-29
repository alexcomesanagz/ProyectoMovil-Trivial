package com.example.triviaapp.viewModels.Uis

import android.util.Log
import com.example.triviaapp.R
import com.example.triviaapp.componentes.Tarjeta

data class PaginaLoginUi(
    val stringCorreo: String = "",
    val stringContrasena: String = ""
)

data class PaginaPerfilUi(
    val imagenPerfil: Int = R.drawable.perfil,
    val nombreUsuario: String="",
    val correoUsuario: String="@gmail.com",
    val tarjetasUsuario: List<Tarjeta> = listOf(
        Tarjeta(
            imagen = R.drawable.trivia,
            titulo = "Cultura General"),
        Tarjeta(
            imagen = R.drawable.trivia,
            titulo = "Historia"),
        Tarjeta(
            imagen = R.drawable.trivia,
            titulo = "Ciencia"),
        Tarjeta(
            imagen = R.drawable.trivia,
            titulo = "Deportes")
    )
)

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

data class TagetaUiDatos(
    val imagen: Int=R.drawable.trivia,
    val titulo: String="",
    val accion: () -> Unit = { Log.e("Testeo","tarjeta cliqueada")},
    val id: String = ""
)
data class PaginaListaUiState(
    val mapaDatos: Map<String, List<TagetaUiDatos>> = mapOf<String,List<TagetaUiDatos>>( "susto" to
            listOf(TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TagetaUiDatos(R.drawable.trivia,"Trivia 2")),
        "resusto" to
                listOf(TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TagetaUiDatos(R.drawable.trivia,"Trivia 2")),
        "cagao" to  listOf(TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TagetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TagetaUiDatos(R.drawable.trivia,"Trivia 2")))
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
    val tarjetasLista1: List<Tarjeta> = listOf<Tarjeta>(Tarjeta(),Tarjeta()),
    val tarjetasLista2: List<Tarjeta> = listOf<Tarjeta>(Tarjeta(),Tarjeta()),
)