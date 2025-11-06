package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ComponenteBotonesHorizontal(txtBotones: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            BotonesDobleAceptarLinea(txtBotones.get(0), txtBotones.get(1))
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            BotonesDobleAceptarLinea(txtBotones.get(2), txtBotones.get(3))
        }
    }
}

@Preview
@Composable
fun PrevComponenteBotonesHorizontal() {
    val txtBotones: List<String> = listOf(
        "1", "2", "3", "4"
    )

    ComponenteBotonesHorizontal(txtBotones)
}