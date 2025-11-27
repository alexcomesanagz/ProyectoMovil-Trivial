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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.BotonesDobleAceptarLinea
import com.example.triviaapp.componentes.BotonesDobleAvanzarLinea
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestas
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.ComponenteTituloConBotonesHorizontal
import com.example.triviaapp.componentes.DatosBotonDoble


val txtTitulo = "Opción correcta"

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
            .padding(vertical = 30.dp, horizontal = 10.dp)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
                ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)
                ComponenteTituloConBotonesHorizontal(
                    txtTitulo,
                    txtBotones,
                    accionBotones = accionbotones
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ComponenteTitulo(preguntaActual + " / " + numPreguntas)
                Box(
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    BotonesDobleAvanzarLinea(DatosBotonDoble(txtAnterior,
                        txtSiguiente,
                        accionBoton1 = { Log.e("Testing", "Aceptar boton cliqueado") },
                        accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteLinea()
                BotonesAceptarDenegarLinea(DatosBotonDoble(txtSalir,
                    txtFinalizar,
                    accionBoton1 = { Log.e("Testing", "Denegar boton cliqueado") },
                    accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
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