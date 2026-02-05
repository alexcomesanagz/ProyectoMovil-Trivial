package com.example.triviaapp.viewModels.Uis

import android.util.Log
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
    val imagenPerfil: Int = R.drawable.perfil,
    val nombreUsuario: String="",
    val correoUsuario: String="@gmail.com",
    val tarjetasUsuario: List<TajetaUiDatos> = listOf(
        TajetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Cultura General"),
        TajetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Historia"),
        TajetaUiDatos(
            imagen = R.drawable.trivia,
            titulo = "Ciencia"),
        TajetaUiDatos(
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
    val mapaDatos: Map<String, List<TajetaUiDatos>> = mapOf<String,List<TajetaUiDatos>>(
        "susto" to
            listOf(TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                TajetaUiDatos(R.drawable.trivia,"Trivia 2")),
        "resusto" to
                listOf(TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
                    TajetaUiDatos(R.drawable.trivia,"Trivia 2")),
        "cagao" to  listOf(TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TajetaUiDatos(R.drawable.trivia,"Trivia 2"),
            TajetaUiDatos(R.drawable.trivia,"Trivia 2")))
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
    val tarjetasLista1: List<TajetaUiDatos> = listOf<TajetaUiDatos>(TajetaUiDatos(titulo = "awawa"),TajetaUiDatos(titulo = "awawa")),
    val tarjetasLista2: List<TajetaUiDatos> = listOf<TajetaUiDatos>(TajetaUiDatos(titulo = "awawa"),TajetaUiDatos(titulo = "awawa")),
)

data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String ="1",
    var id: String=""
)

data class TajetaUiDatos(
    val imagen: Int=R.drawable.trivia,
    val titulo: String="",
    val id: String = ""
)
