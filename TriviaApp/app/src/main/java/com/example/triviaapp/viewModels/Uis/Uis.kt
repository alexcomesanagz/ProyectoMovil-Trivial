package com.example.triviaapp.viewModels.Uis

import com.example.triviaapp.R
import com.example.triviaapp.componentes.Tarjeta

data class PaginaLoginUi(
    val stringCorreo: String = "",
    val stringContrasena: String = "",
    val contrasenaVisible: Boolean=false
)

data class MainUi(
    val scaffold: Boolean=true,
    val botonFlotante: Boolean=true,
    val logueado: Boolean=false
)
data class PaginaPerfilUi(
    val imagenPerfil: String = "R.drawable.perfil",
    val nombreUsuario: String="",
    val correoUsuario: String="@gmail.com",
    val tarjetasUsuario: List<TarjetaUiDatos> = listOf(
)
)
data class PaginaSignUpUi(
    val nombreUsuario:String="",
    val stringCorreo: String = "",
    val stringContrasena: String = ""
)
data class PaginaAjustesUi(
    val nombreTriv:String="",
    val categoria: String="1",
    val preguntas: Int=0
    )

data class CreaPreguntasUIState(
    val preguntas: List<Pregunta> =listOf(),
    val i: Int = 0
)
data class PaginaFinUiState(
    val id:String="",
    val preguntasAcertadas: Int = 5,
    val preguntasTotales: Int = 10,
    val imagenResultado: String = "R.drawable.trivia"
)


data class PaginaListaUiState(
    val mapaDatos: List<TarjetaUiDatos> =listOf<TarjetaUiDatos>(),
    val tarjetas: Map<String,List<Tarjeta>> = mapOf<String,List<Tarjeta>>()
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
    val tarjetasLista1: List<TarjetaUiDatos> = listOf<TarjetaUiDatos>(),
    val tarjetasLista2: List<TarjetaUiDatos> = listOf<TarjetaUiDatos>()
)

data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String ="1",
    var id: String=""
)

data class TarjetaUiDatos(
    val imagen: String="",
    val titulo: String="",
    val id: String = ""
)
