package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
class DatosRespondePregunta(
    val enunciado: String,
    val textoBotonesRespuesta: List<String>,
    val paddingBotonesTitulo: Int = 8,
    val respuesta: String,
    val accionRespuestas: (String) -> String={""}

)


@Composable
fun ComponentePreguntaYCategorias(
datos: DatosRespondePregunta
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(datos.paddingBotonesTitulo.dp),
        modifier = Modifier.background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
    ) {
        ComponenteTitulo(datos.enunciado)
        ComponenteRadioButonCategorias(
            DatosRadioBotones(
                txtBotones = datos.textoBotonesRespuesta,
                remember = datos.respuesta,
                accion = datos.accionRespuestas
            )
        )
    }
}

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
                remember = datos.respuesta,
                accion = datos.accionRespuestas
            )
        )
    }
}



class DatosCreaPregunta(
    val enunciado: String,
    val textoBotonesRespuesta: List <String>,
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
        Box( modifier = Modifier.background(MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp)
        )
            .padding(vertical = 6.dp, horizontal = 20.dp)
            .fillMaxWidth()) {
            ComponenteTextField(
                DatosTextField(
                    msjPregunta = "introduzca la pregunta ",
                    listaColor = listOf(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.onSecondary,
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.onPrimary),
                    txtContenido = datos.enunciado,
                    accion = datos.accionEnunciado
                )
            )
        }
        ComponenteRespuestasTextBox(
            textoBotonesRespuesta = datos.textoBotonesRespuesta,
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