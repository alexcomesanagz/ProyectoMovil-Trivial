package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.triviaapp.R


@Composable
fun ComponenteTituloConBotonesHorizontal(txtTitulo: String, txtbotones: List<String>) {
    Column(
        modifier = Modifier
    ) {
        ComponenteTitulo(txtTitulo)
        ComponenteBotonesHorizontal(txtbotones)
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