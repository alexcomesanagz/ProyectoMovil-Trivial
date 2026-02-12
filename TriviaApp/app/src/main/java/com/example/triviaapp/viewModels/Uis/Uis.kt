package com.example.triviaapp.viewModels.Uis

import com.example.triviaapp.R

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
    val imagenPerfil: Int = R.drawable.perfil,
    val nombreUsuario: String="",
    val correoUsuario: String="@gmail.com",
    val tarjetasUsuario: List<TarjetaUiDatos> = listOf(
        TarjetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Cultura General"),
        TarjetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Historia"),
        TarjetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Ciencia"),
        TarjetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Deportes")
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

data class ElegirRespUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0
)
data class PaginaFinUiState(
    val id:String="",
    val preguntasAcertadas: Int = 5,
    val preguntasTotales: Int = 10,
    val imagenResultado: Int = R.drawable.trivia
)


data class PaginaListaUiState(
    val mapaDatos: Map<String, List<TarjetaUiDatos>> = mapOf<String,List<TarjetaUiDatos>>(
        "susto" to
            listOf(TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TarjetaUiDatos(R.drawable.trivia,"Trivia 2")),
        "resusto" to
                listOf(TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TarjetaUiDatos(R.drawable.trivia,"Trivia 2")),
        "cagao" to  listOf(TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TarjetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TarjetaUiDatos(R.drawable.trivia,"Trivia 2")))
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
    val tarjetasLista1: List<TarjetaUiDatos> = listOf<TarjetaUiDatos>(TarjetaUiDatos(titulo = "awawa"),TarjetaUiDatos(titulo = "awawa")),
    val tarjetasLista2: List<TarjetaUiDatos> = listOf<TarjetaUiDatos>(TarjetaUiDatos(titulo = "awawa"),TarjetaUiDatos(titulo = "awawa")),
)

data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String ="1",
    var id: String=""
)

data class TarjetaUiDatos(
    val imagen: Int=R.drawable.trivia,
    val titulo: String="",
    val id: String = ""
)
