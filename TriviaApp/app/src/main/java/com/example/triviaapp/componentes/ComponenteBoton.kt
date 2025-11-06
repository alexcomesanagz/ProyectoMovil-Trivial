package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.util.unpackFloat1

class DatosBoton(
    val msj: String,
    val modifier: Modifier = Modifier,
    val coloresBoton: List<Color>,
    val accion: () -> Unit
)

@Composable
fun ComponenteBoton(datos: DatosBoton) {
    Button(
        onClick = datos.accion, colors = ButtonColors(
            containerColor = datos.coloresBoton.get(0),
            contentColor = datos.coloresBoton.get(1),
            disabledContainerColor = datos.coloresBoton.get(2),
            disabledContentColor = datos.coloresBoton.get(3),
        ),
        modifier = datos.modifier
    ) {
        Text(text = datos.msj)
    }
}

@Composable
fun AceptartBoton(
    msj: String,
    modifier: Modifier = Modifier,
    accion: () -> Unit = { Log.e("Testing", "Aceptar boton cliqueado") }
) {
    var listaColor = listOf<Color>(
        MaterialTheme.colorScheme.primaryContainer,
        MaterialTheme.colorScheme.onPrimaryContainer,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.onPrimaryContainer
    )
    ComponenteBoton(
        datos = DatosBoton(
            msj = msj,
            modifier = modifier,
            coloresBoton = listaColor,
            accion = accion
        )
    )
}

@Composable
fun DenegartBoton(
    msj: String,
    modifier: Modifier = Modifier,
    accion: () -> Unit = { Log.e("Testing", "Denegar boton cliqueado") }
) {
    var listaColor = listOf<Color>(
        MaterialTheme.colorScheme.error,
        MaterialTheme.colorScheme.scrim,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.onPrimaryContainer
    )
    ComponenteBoton(
        datos = DatosBoton(
            msj = msj,
            modifier = modifier,
            coloresBoton = listaColor,
            accion = accion
        )
    )
}


@Preview
@Composable
fun BotonPreview() {
    Column {
        AceptartBoton("aya")
        DenegartBoton("aya")
    }
}