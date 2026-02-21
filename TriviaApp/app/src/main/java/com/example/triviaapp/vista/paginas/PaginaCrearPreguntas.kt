package com.example.triviaapp.vista.paginas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.BotonesDobleAvanzarLinea
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestasRellenar
import com.example.triviaapp.componentes.ComponenteTituloCaja
import com.example.triviaapp.componentes.ComponenteTituloConRadioButonHorizontal
import com.example.triviaapp.componentes.DatosBotonDoble
import com.example.triviaapp.componentes.DatosCreaPregunta
import com.example.triviaapp.viewModels.vm.CrearRespViewModel


/**
 * Pagina para rellenar una preguntas a la hora de hacer un quiz
 */
@Composable
fun PaginaElegirRespuestas(
    idTrivia: String,
    crearPreguntas: CrearRespViewModel = viewModel(),
    onClickSalir: () -> Unit,
    onClickAceptar: () -> Unit
) {
    LaunchedEffect(idTrivia) {
        crearPreguntas.cargar(idTrivia)
    }
    val uiState by crearPreguntas.uiState.collectAsState()
    val txtBotones: List<String> = listOf(
        stringResource(R.string.app_sleccion_resp_1),
        stringResource(R.string.app_sleccion_resp_2),
        stringResource(R.string.app_sleccion_resp_3),
        stringResource(R.string.app_sleccion_resp_4)
    )
    val preguntaActual = uiState.preguntas.getOrNull(uiState.i)
    if (preguntaActual == null) {
        return
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Column(
                Modifier
                    .padding(vertical = 30.dp, horizontal = 10.dp)
                    .windowInsetsPadding(WindowInsets.safeDrawing)
            ) {

                    ComponentePreguntaYRespuestasRellenar(
                        DatosCreaPregunta(
                            enunciado = preguntaActual.pregunta,
                            textoBotonesRespuesta = preguntaActual.textoBotonesRespuestas,
                            accionEnunciado = { it -> crearPreguntas.cambiaPregunta(it) },
                            accionRespuestas = { i, it -> crearPreguntas.cambiaTextoBoton(i, it) }
                        )
                    )
                    ComponenteTituloConRadioButonHorizontal(
                        stringResource(R.string.app_opcion_correcta),
                        txtBotones,
                        remember = preguntaActual.respuestaCorrecta,
                        accion = { it -> crearPreguntas.cambiaRespuestaCorrecta(it) }
                    )


                    ComponenteTituloCaja("${uiState.i + 1} / ${crearPreguntas.getNumPreguntas()} ")
                    Box(
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                        BotonesDobleAvanzarLinea(
                            DatosBotonDoble(
                                stringResource(R.string.app_bt_anterior),
                                stringResource(R.string.app_bt_siguiente),
                                accionBoton1 = { crearPreguntas.anteriorPregunta(idTrivia) },
                                accionBoton2 = { crearPreguntas.siguientePregunta(idTrivia) })
                        )
                    }


                    ComponenteLinea()
                    BotonesAceptarDenegarLinea(
                        DatosBotonDoble(
                            stringResource(R.string.app_bt_salir),
                            stringResource(R.string.app_bt_finalizar),
                            accionBoton1 = {
                                crearPreguntas.cancelarCreacion(
                                    idTrivia = idTrivia,
                                    onSucces = onClickSalir,
                                    onError = {}
                                )
                            },
                            accionBoton2 = {
                                crearPreguntas.fin(idTrivia,onClickAceptar, {})
                            }
                        )
                    )


            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevPaginaElegirRespuestas() {
//    TriviaAppTheme {
    PaginaElegirRespuestas("1", onClickSalir = { "" }, onClickAceptar = { "" })
//    }
}