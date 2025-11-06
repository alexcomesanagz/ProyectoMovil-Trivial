package com.example.triviaapp.paginas

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
import com.example.triviaapp.componentes.ComponentePreguntaYRespuestas
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.ComponenteTituloConBotonesHorizontal
import com.example.triviaapp.componentes.DatosBotonDoble


val txtTitulo = "Opción correcta"

val txtBotones: List<String> = listOf(
    "1", "2", "3", "4"
)

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
                BotonesAceptarDenegarLinea(DatosBotonDoble(txtSalir, txtFinalizar))
                ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                ComponenteTitulo(preguntaActual + " / " + numPreguntas)
                BotonesDobleAceptarLinea(DatosBotonDoble(txtAnterior, txtSiguiente))
            }
            Column(
                modifier = Modifier.padding(vertical = 10.dp)
            ){
                ComponenteTituloConBotonesHorizontal(txtTitulo, txtBotones)
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