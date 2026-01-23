package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Crea un set de 4 botones organizados en
 * 2 filas y 2 columnas debajo de una pregunta, texto
 * @param enunciado contenido de la pregunta
 * @param textoBotonesRespuesta lista de contenido de cada boton, tiene que haber solo 4
 */
class DatosRespondePregunta(
    val enunciado: String,
    val textoBotonesRespuesta: List<String>,
    val paddingBotonesTitulo: Int = 8,
    val respuesta: String
)


@Composable
fun ComponentePreguntaYRespuestas(
datos: DatosRespondePregunta
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(datos.paddingBotonesTitulo.dp),
        modifier = Modifier.background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
    ) {
        ComponenteTitulo(datos.enunciado)
        ComponenteRespuestasRadioButon(
            DatosRadioBotones(
                txtBotones = datos.textoBotonesRespuesta,
                remember = datos.respuesta
            )
        )
    }
}


class DatosCreaPregunta(
    val enunciado: String,
    val textoBotonesRespuesta: List <MutableState<String>>,
    val paddingBotonesTitulo: Int = 8,
    val accionEnunciado: (String) -> String={""},
    val accionRespuestas: (Int,String) -> String={i,it-> ""}
)

@Composable
fun ComponentePreguntaYRespuestasRellenar(
   datos: DatosCreaPregunta
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(datos.paddingBotonesTitulo.dp),
        modifier = Modifier.background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
    ) {
        ComponenteTextField(
                DatosTextField(
                "introduzca la pregunta ",
                datos.enunciado,
                    accion =datos.accionEnunciado
                )
        )
        ComponenteRespuestasTextBox(
            datos.textoBotonesRespuesta,
            accion = datos.accionRespuestas
        )
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

    //ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)
}