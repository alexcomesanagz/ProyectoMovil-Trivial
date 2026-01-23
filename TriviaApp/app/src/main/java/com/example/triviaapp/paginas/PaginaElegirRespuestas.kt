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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.BotonesDobleAvanzarLinea
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestasRellenar
import com.example.triviaapp.componentes.ComponenteTituloCaja
import com.example.triviaapp.componentes.ComponenteTituloConRadioButonHorizontal
import com.example.triviaapp.componentes.DatosBotonDoble
import com.example.triviaapp.componentes.DatosCreaPregunta
import com.example.triviaapp.viewModels.ElegirRespViewModel



/**
 * Pagina para rellenar una preguntas a la hora de hacer un quiz
 */
@Composable
fun PaginaElegirRespuestas(elegirRespuestas: ElegirRespViewModel = viewModel()) {
    val uiState by elegirRespuestas.uiState.collectAsState()
    val txtBotones: List<String> = listOf(
        stringResource(R.string.app_sleccion_resp_1),
        stringResource(R.string.app_sleccion_resp_2),
        stringResource(R.string.app_sleccion_resp_3),
        stringResource(R.string.app_sleccion_resp_4)
    )



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
                        enunciado = elegirRespuestas.getPregunta().pregunta,
                        textoBotonesRespuesta = elegirRespuestas.getPregunta().textoBotonesRespuestas,
                        accionEnunciado = {it-> elegirRespuestas.cambiaPregunta(it)},
                        accionRespuestas = {i,it->elegirRespuestas.cambiaTextoBoton(i,it)}
                    )
                )
                ComponenteTituloConRadioButonHorizontal(
                    stringResource(R.string.app_opcion_correcta),
                    txtBotones,
                    remember = elegirRespuestas.getPregunta().respuestaCorrecta,
                    accion = {it-> elegirRespuestas.cambiaRespuestaBoton(it)}
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
                ComponenteTituloCaja( "${uiState.i+1} / ${elegirRespuestas.getNumPreguntas()}")
                Box(
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    BotonesDobleAvanzarLinea(
                        DatosBotonDoble(
                            stringResource(R.string.app_bt_anterior),
                            stringResource(R.string.app_bt_siguiente),
                            accionBoton1 = { elegirRespuestas.anteriorPregunta() },
                            accionBoton2 = { elegirRespuestas.siguientePregunta()})
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