package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

/**
 *set de cuatro botones en fila debajo de un texto
 * @param txtTitulo contenido del texto
 * @param txtbotones lista de contenido de cada boton, tiene que haber solo 4
 * @param tamañoTexto tamaño de el texto que contienen los botones
 */
@Composable
fun ComponenteTituloConBotonesHorizontal(
    txtTitulo: String,
    txtbotones: List<String>,
    tamañoTexto:Int=12
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ComponenteTitulo(txtTitulo)
        ComponenteBotonesHorizontal(txtbotones, tamañoTexto = tamañoTexto)
    }
}

@Preview
@Composable
fun PrevComponenteTituloConBotonesHorizontal() {
    val txtTitulo = "Opción correcta"

    val txtbotones: List<String> = listOf(
        "1", "2", "3", "4"
    )
    ComponenteTituloConBotonesHorizontal(txtTitulo, txtbotones)
}