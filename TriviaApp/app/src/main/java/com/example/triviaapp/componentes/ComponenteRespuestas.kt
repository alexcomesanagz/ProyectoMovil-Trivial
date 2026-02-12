package com.example.triviaapp.componentes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
    textoBotonesRespuesta: List <String>,
    accion: (Int, String) -> String={i,it ->""}

) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            itemsIndexed(items = textoBotonesRespuesta,
                key ={ index, _ -> index }
            ){i, textoBoton ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding( 10.dp)
                ) {
                    ComponenteTextFieldLista(
                        DatosTextFieldLista(
                            msjPregunta = "introduzca respuesta "+(i+1),
                            txtContenido = textoBoton,
                            i = i,
                            modif = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary),
                            accion = accion
                        )
                    )

                }
            }
        }
    )
}


@Composable
fun ComponenteRadioButonCategorias(
    datos: DatosRadioBotones
) {
    var listaColor = listOf<Color>(
    MaterialTheme.colorScheme.surface,
    MaterialTheme.colorScheme.primary,
    MaterialTheme.colorScheme.onPrimary
)
    LazyVerticalGrid(modifier = Modifier.padding(5.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(items = datos.txtBotones)
                { textoBoton ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding( 5.dp)
                    .fillMaxWidth()
                ) {
                    ComponenteRadioButon(
                        DatosRadioBoton(
                            msj = textoBoton,
                            boton = textoBoton,
                            coloresBoton = listaColor,
                            rememberCadena = datos.remember,
                            accion = datos.accion
                        )
                    )
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
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onPrimary
    )
    LazyVerticalGrid(modifier = Modifier.padding(5.dp),
        columns = GridCells.Fixed(2),
        content = {
            itemsIndexed(items = datos.txtBotones,
                key ={ index, _ -> index }
            ) {i, textoBoton ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding( 5.dp)
                        .fillMaxWidth()
                ) {
                    ComponenteRadioButon(
                        DatosRadioBoton(
                            msj = textoBoton,
                            boton = ""+(i+1),
                            coloresBoton = listaColor,
                            rememberCadena = datos.remember,
                            accion = datos.accion
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