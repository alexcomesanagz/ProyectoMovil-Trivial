package com.example.triviaapp.paginas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.BotonesDobleAvanzarLinea
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestas
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestasRellenar
import com.example.triviaapp.componentes.ComponenteTituloCaja
import com.example.triviaapp.componentes.ComponenteTituloConBotonesHorizontal
import com.example.triviaapp.componentes.ComponenteTituloConRadioButonHorizontal
import com.example.triviaapp.componentes.DatosBotonDoble
import com.example.triviaapp.componentes.DatosCreaPregunta
import com.example.triviaapp.componentes.DatosRespondePregunta


val txtTitulo = "Opción correcta"

val txtBotones: List<String> = listOf(
    "1", "2", "3", "4"
)

val enunciado =mutableStateOf("")

val textoBotonesRespuestas = listOf(
    mutableStateOf(""),
    mutableStateOf(""),
    mutableStateOf(""),
    mutableStateOf("")
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

    var recuerdaRadioButon = remember { mutableStateOf(txtBotones[0]) }

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
                ComponentePreguntaYRespuestasRellenar(
                    DatosCreaPregunta(
                        enunciado,
                        textoBotonesRespuestas
                    )
                )
                ComponenteTituloConRadioButonHorizontal(
                    txtTitulo,
                    txtBotones,
                    remember = recuerdaRadioButon
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .background(
                        MaterialTheme.colorScheme.surface,
                        RoundedCornerShape(12.dp)
                    )
            ) {

                ComponenteTituloCaja(preguntaActual + " / " + numPreguntas)
                Box(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    BotonesDobleAvanzarLinea(
                        DatosBotonDoble(
                            stringResource(R.string.app_bt_anterior),
                            stringResource(R.string.app_bt_siguiente),
                            accionBoton1 = { Log.e("Testing", "Aceptar boton cliqueado") },
                            accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") })
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteLinea()
                BotonesAceptarDenegarLinea(
                    DatosBotonDoble(
                        stringResource(R.string.app_bt_salir),
                        stringResource(R.string.app_bt_finalizar),
                        accionBoton1 = { Log.e("Testing", "Denegar boton cliqueado") },
                        accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") })
                )
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