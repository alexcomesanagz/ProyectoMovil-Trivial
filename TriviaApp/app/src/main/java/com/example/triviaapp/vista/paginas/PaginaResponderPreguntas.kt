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
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.BotonesDobleAvanzarLinea
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestas
import com.example.triviaapp.componentes.ComponenteTituloCaja
import com.example.triviaapp.componentes.DatosBotonDoble
import com.example.triviaapp.componentes.DatosRespondePregunta
import com.example.triviaapp.viewModels.vm.ResponderPreguntasViewModel


val textoBotonesRespuesta = listOf(
    "1 a",
    "2 a",
    "3 a",
    "4 a"
)

/**
 * Pagina para responder una de las preguntas de un trivia ya creado
 */
@Composable
fun PaginaResponderPreguntas(
    idTrivia: String,
    responderPregunta: ResponderPreguntasViewModel = viewModel(),
    accionFin: (String)-> Unit,
    accionCancelar: ()->Unit
) {
    val uiState by responderPregunta.uiState.collectAsState()
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 70.dp, horizontal = 10.dp)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Column(

        ) {
            Column(verticalArrangement = Arrangement.spacedBy(50.dp)) {
                ComponentePreguntaYRespuestas(
                    DatosRespondePregunta(
                        enunciado = "enunciado",
                        textoBotonesRespuesta,
                        respuesta = responderPregunta.getPregunta().respuestaSeleccionada,
                        accionRespuestas = { it -> responderPregunta.cambiaRespuestaBoton(it) }
                    )
                )
                ComponenteTituloCaja("${uiState.i + 1} / ${responderPregunta.getNumPreguntas()}")
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 60.dp)
                        .background(
                            MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                ) {
                    BotonesDobleAvanzarLinea(
                        DatosBotonDoble(
                            stringResource(R.string.app_bt_anterior),
                            stringResource(R.string.app_bt_siguiente),
                            accionBoton1 = { responderPregunta.anteriorPregunta() },
                            accionBoton2 = { responderPregunta.siguientePregunta() })
                    )
                }
                ComponenteLinea()
                BotonesAceptarDenegarLinea(
                    datosBotones = DatosBotonDoble(
                        stringResource(R.string.app_bt_salir),
                        stringResource(R.string.app_bt_finalizar),
                        accionBoton1 = accionCancelar ,
                        accionBoton2 = { accionFin(idTrivia) })
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevPaginaResponderPreguntas() {
//    TriviaAppTheme(darkTheme = true) {
    PaginaResponderPreguntas("a", accionFin = {}, accionCancelar = {})
//    }
}