package com.example.triviaapp.componentes

import android.util.Log
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
 * @param accionBotones contiene las acciones de cada boton
 * @param tamañoTexto tamaño de el texto que contienen los botones
 */
@Composable
fun ComponenteTituloConBotonesHorizontal(
    txtTitulo: String,
    txtbotones: List<String>,
    accionBotones:List<() -> Unit>,
    tamañoTexto:Int=12
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ComponenteTitulo(txtTitulo)
        ComponenteBotonesHorizontal(txtbotones,
            accionBotones = accionBotones,
            tamañoTexto = tamañoTexto)
    }
}

@Preview
@Composable
fun PrevComponenteTituloConBotonesHorizontal() {
    val txtTitulo = "Opción correcta"

    val txtbotones: List<String> = listOf(
        "1", "2", "3", "4"
    )
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )
    ComponenteTituloConBotonesHorizontal(txtTitulo, txtbotones,accionbotones)
}