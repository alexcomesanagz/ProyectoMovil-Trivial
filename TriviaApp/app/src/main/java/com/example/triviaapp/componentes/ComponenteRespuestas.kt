package com.example.triviaapp.componentes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Set de 4 botones repartidos en 2 filas y 2 columnas
 * @param textoBotonesRespuesta lista de contenido de cada boton, tiene que haber solo 4
 */
@Composable
fun ComponenteRespuestasTextBox(
    textoBotonesRespuesta: List<MutableState<String>>
) {
    var i=0
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(textoBotonesRespuesta) { textoBoton ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding( 10.dp)
                ) {
                    ComponenteTextField(
                        DatosTextField(
                            msjPregunta = "introduzca respuesta "+i,
                            txtContenido = textoBoton,
                            modif = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary)
                        )
                    )
                    i++
                }
            }
        }
    )
}


@Composable
fun ComponenteRespuestasRadioButon(
    datos: DatosRadioBotones
) {
    var listaColor = listOf<Color>(
    MaterialTheme.colorScheme.surface,
    MaterialTheme.colorScheme.surface,
    MaterialTheme.colorScheme.primary,
    MaterialTheme.colorScheme.onPrimary
)
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(datos.txtBotones) { textoBoton ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    ComponenteRadioButon(
                        DatosRadioBoton(
                            textoBoton,
                            listaColor,
                            remember = datos.remember
                        )
                    )
                }
            }
        }
    )
}


@Preview(showSystemUi = true)
@Composable
fun prevComponenteRespuestas() {
    val textoBotonesRespuesta = listOf(
        "Respuesta 1",
        "Respuesta 2",
        "Respuesta 3",
        "Respuesta 4"
    )
   // ComponenteRespuestas(textoBotonesRespuesta)
}