package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * crea 4 botones divididos entre 2 filas y 2 columnas
 * @param txtBotones contiene el texto de cada boton, tienen que ser 4
 * @param tamañoTexto tamaño de el texto que contienen los botones
 * @param accionBotones contiene las acciones de cada boton
 */
@Composable
fun ComponenteBotonesHorizontal(
    txtBotones: List<String>,
    accionBotones:List<() -> Unit>,
    tamañoTexto:Int=12
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            BotonesDobleAceptarLinea(DatosBotonDoble(
                txtBotones.get(0),
                txtBotones.get(1),
                accionBoton1 = accionBotones.get(0),
                accionBoton2 = accionBotones.get(1),
                tamañoTexto = tamañoTexto)
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            BotonesDobleAceptarLinea(DatosBotonDoble(
                txtBotones.get(2),
                txtBotones.get(3),
                accionBoton1 = accionBotones.get(2),
                accionBoton2 = accionBotones.get(3),
                tamañoTexto = tamañoTexto)
            )
        }
    }
}

@Preview
@Composable
fun PrevComponenteBotonesHorizontal() {
    val txtBotones: List<String> = listOf(
        "1", "2", "3", "4"
    )
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )

    ComponenteBotonesHorizontal(txtBotones, accionBotones = accionbotones)
}