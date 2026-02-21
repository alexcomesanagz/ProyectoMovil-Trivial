package com.example.triviaapp.viewModels.Uis

import com.example.triviaapp.componentes.Tarjeta

/**
 * objeto que utiliza la pagina de inicio de sesion
 * @param stringNombre nombre del usuario
 * @param stringContrasena contraseña del usuario
 * @param contrasenaVisible indica si el usuario tiene la contraseña para que se muestre o no
 */
data class PaginaInicioSesionUi(
    val stringNombre: String = "",
    val stringContrasena: String = "",
    val contrasenaVisible: Boolean=false
)

/**
 * objeto que utiliza el main
 * @param scaffold indica si se quiere que sea visible el scafold o no
 * @param botonFlotante indica si se quiere que sea visible el boton flotante o no
 * @param logueado indica si el usuario esta logueado
 */
data class MainUi(
    val scaffold: Boolean=true,
    val botonFlotante: Boolean=true,
    val logueado: Boolean=false
)

/**
 * objeto de la pagina perfil
 * @param imagenPerfil imagen del perfil del usuario
 * @param nombreUsuario nombre del usuario
 * @param correoUsuario correo del usuario
 * @param tarjetasUsuario lista de trivias que creo el usuario
 */
data class PaginaPerfilUi(
    val imagenPerfil: String = "R.drawable.perfil",
    val nombreUsuario: String="",
    val correoUsuario: String="@gmail.com",
    val tarjetasUsuario: List<TarjetaUiDatos> = listOf()
)

/**
 * objeto de pagina registrarse
 * @param nombreUsuario nombre del usuario
 * @param stringContrasena contraseña del usuario
 * @param stringCorreo correo del usuario
 */
data class PaginaRegistrarse(
    val nombreUsuario:String="",
    val stringCorreo: String = "",
    val stringContrasena: String = ""
)

/**
 * objeto de la pagina de ajustes
 * @param nombreTriv nombre del trivia
 * @param categoria categoria del trivia
 * @param preguntas numero de preguntas que se quiera que tenga el trivia
 */
data class PaginaAjustesUi(
    val nombreTriv:String="",
    val categoria: String="1",
    val preguntas: Int=0
    )

/**
 * objeto de la pagina crea preguntas
 * @param preguntas preguntas
 * @param i pregunta en la que se está
 */
data class CreaPreguntasUIState(
    val preguntas: List<Pregunta> =listOf(),
    val i: Int = 0
)

/**
 * objeto de la pagina fin
 * @param preguntasTotales preguntas totales del trivial
 * @param preguntasAcertadas preguntas que acerto el usuario
 * @param imagenResultado imagen que se mostrara segun el resultado
 */
data class PaginaFinUiState(
    val preguntasAcertadas: Int = 5,
    val preguntasTotales: Int = 10,
    val imagenResultado: String = "R.drawable.trivia"
)

/**
 * objeto de la pagina lista
 * @param listaDatos lista de trivias
 * @param tarjetas mapa de las tarjetas agrupadas por categoria
 */
data class PaginaListaUiState(
    val listaDatos: List<TarjetaUiDatos> =listOf<TarjetaUiDatos>(),
    val tarjetas: Map<String,List<Tarjeta>> = mapOf<String,List<Tarjeta>>()
)

/**
 * objeto de pagina responder preguntas
 * @param preguntas las preguntas a responder
 * @param i pregunta en la que se está
 */
data class ResponderPregUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    val i: Int = 0
)

/**
 * objeto de la pagina principal
 * @param recomendados lista de trivias que se recomiendan
 * @param recientes lista de trivias el usuario ya empezó
 */
data class PrincipalUiState(
    val recomendados: List<TarjetaUiDatos> = listOf<TarjetaUiDatos>(),
    val recientes: List<TarjetaUiDatos> = listOf<TarjetaUiDatos>()
)

/**
 * objeto que representa a una pregunta
 * @param textoBotonesRespuestas lista que contiene el texto de las respuestas
 * @param respuestaCorrecta respuesta que es la correcta
 * @param pregunta texto de la pregunta
 * @param respuestaSeleccionada respuesta seleccionada por el usuario
 */
data class Pregunta(
    val textoBotonesRespuestas: List<String> =List(4){""},
    var respuestaCorrecta: String="1",
    var pregunta: String = "",
    var respuestaSeleccionada:String ="1",
    var id: String=""
)

/**
 * objeto que representa una tarjeta
 * @param imagen imagen de la tarjeta
 * @param titulo nombre de la tarjeta
 */
data class TarjetaUiDatos(
    val imagen: String="",
    val titulo: String="",
    val id: String = ""
)
