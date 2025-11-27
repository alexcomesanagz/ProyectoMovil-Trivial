package com.example.triviaapp.componentes


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Set de 4 botones repartidos en 2 filas y 2 columnas
 * @param textoBotonesRespuesta lista de contenido de cada boton, tiene que haber solo 4
 */
@Composable
fun ComponenteRespuestas(textoBotonesRespuesta: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(textoBotonesRespuesta) { textoBoton ->
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    AceptarBoton(
                        msj = textoBoton,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(50.dp))
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
    ComponenteRespuestas(textoBotonesRespuesta)
}