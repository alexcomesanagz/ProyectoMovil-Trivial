package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Crea un set de 4 botones organizados en
 * 2 filas y 2 columnas debajo de una pregunta, texto
 * @param enunciado contenido de la pregunta
 * @param textoBotonesRespuesta lista de contenido de cada boton, tiene que haber solo 4
 */
@Composable
fun ComponentePreguntaYRespuestas(
    enunciado: String,
    textoBotonesRespuesta: List<String>,
    paddingBotonesTitulo: Int = 15
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(paddingBotonesTitulo.dp)
    ) {
        ComponenteTitulo(enunciado)
        ComponenteRespuestas(textoBotonesRespuesta)
    }
}

@Preview(showSystemUi = true)
@Composable
fun prevComponentePreguntaYRespuestas() {
    val enunciado =
        " ¿La invasión de qué fortaleza por parte de los revolucionarios es considerada como el punto de inicio de la Revolución Francesa?"

    val textoBotonesRespuesta = listOf(
        "Respuesta 1",
        "Respuesta 2",
        "Respuesta 3",
        "Respuesta 4"
    )

    ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)
}