package com.example.triviaapp.paginas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.BotonesDobleAceptarLinea
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestas
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.DatosBotonDoble

val enunciado =
    "¿La invasión de qué fortaleza por parte de los revolucionarios es considerada como el punto de inicio de la Revolución Francesa?"
val textoBotonesRespuesta = listOf(
    "Respuesta 1",
    "Respuesta 2",
    "Respuesta 3",
    "Respuesta 4"
)

val preguntaActual = "1"
val numPreguntas = "10"

/**
 * Pagina para responder una de las preguntas de un trivia ya creado
 */
@Composable
fun PaginaResponderPreguntas() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(70.dp)) {
                BotonesAceptarDenegarLinea(datosBotones = DatosBotonDoble(
                    stringResource(R.string.app_bt_salir),
                    stringResource(R.string.app_bt_finalizar),
                    accionBoton1 = { Log.e("Testing", "Denegar boton cliqueado") },
                    accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
                ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(70.dp)
            ) {
                ComponenteTitulo(preguntaActual + " / " + numPreguntas)
                BotonesDobleAceptarLinea(DatosBotonDoble(stringResource(R.string.app_bt_anterior),
                    stringResource(R.string.app_bt_siguiente),
                    accionBoton1 = { Log.e("Testing", "Aceptar boton cliqueado") },
                    accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevPaginaResponderPreguntas() {
    TriviaAppTheme {
        PaginaResponderPreguntas()
    }
}