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
import com.example.triviaapp.componentes.ComponenteTituloConBotonesHorizontal
import com.example.triviaapp.componentes.DatosBotonDoble



val txtBotones: List<String> = listOf(
    "1", "2", "3", "4"
)
val accionbotones: List<() -> Unit> = listOf(
    { Log.e("Testing", "Aceptar boton cliqueado") },
    { Log.e("Testing", "Aceptar boton cliqueado") },
    { Log.e("Testing", "Aceptar boton cliqueado") },
    { Log.e("Testing", "Aceptar boton cliqueado") }
)

/**
 * Pagina para rellenar una preguntas a la hora de hacer un quiz
 */
@Composable
fun PaginaElegirRespuestas() {
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
                BotonesAceptarDenegarLinea(DatosBotonDoble(
                    stringResource(R.string.app_bt_salir),
                    stringResource(R.string.app_bt_finalizar),
                    accionBoton1 = { Log.e("Testing", "Denegar boton cliqueado") },
                    accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
                ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                ComponenteTitulo(preguntaActual + " / " + numPreguntas)
                BotonesDobleAceptarLinea(DatosBotonDoble(stringResource(R.string.app_bt_anterior),
                    stringResource(R.string.app_bt_siguiente),
                    accionBoton1 = { Log.e("Testing", "Aceptar boton cliqueado") },
                    accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
            }
            Column(
                modifier = Modifier.padding(vertical = 10.dp)
            ){
                ComponenteTituloConBotonesHorizontal(stringResource(R.string.app_ttl_opcionCorrecta), txtBotones, accionBotones = accionbotones)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevPaginaElegirRespuestas() {
    TriviaAppTheme {
        PaginaElegirRespuestas()
    }
}