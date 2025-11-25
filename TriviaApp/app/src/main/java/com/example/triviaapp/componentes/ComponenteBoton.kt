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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.unpackFloat1


/**
 * @param msj texto que tendrá el boton
 * @param modifier modificador del boton, es opcional
 *
 * @param coloresBoton lista de 4,
 * se utiliza para determinar los colores del boton en orden: contenedor, contenido,
 * contenedor en inactivo y contenido en inactivo
 *
 * @param accion accion del boton al hacer click
 *
 * @param tamañoTexto tamaño de el texto que contiene el boton
 */
class DatosBoton(
    val msj: String,
    val modifier: Modifier = Modifier,
    val coloresBoton: List<Color>,
    val tamañoTexto:Int=12,
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
        Text(text = datos.msj,
            fontSize = datos.tamañoTexto.sp)
    }
}

/**
 * crea un boton de color de fondo claro
 */
@Composable
fun AceptartBoton(
    msj: String,
    modifier: Modifier = Modifier,
    tamañoTexto: Int=12,
    accion: () -> Unit = { Log.e("Testing", "Aceptar boton cliqueado") }
) {
    var listaColor = listOf<Color>(
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.onSurface,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.onPrimaryContainer
    )
    ComponenteBoton(
        datos = DatosBoton(
            msj = msj,
            modifier = modifier,
            coloresBoton = listaColor,
            tamañoTexto = tamañoTexto,
            accion = accion
        )
    )
}

/**
 * crea un boton de color de fondo oscuro
 */
@Composable
fun DenegartBoton(
    msj: String,
    modifier: Modifier = Modifier,
    tamañoTexto: Int=12,
    accion: () -> Unit = { Log.e("Testing", "Denegar boton cliqueado") }
) {
    var listaColor = listOf<Color>(
        MaterialTheme.colorScheme.error,
        MaterialTheme.colorScheme.onError,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.onPrimaryContainer
    )
    ComponenteBoton(
        datos = DatosBoton(
            msj = msj,
            modifier = modifier,
            coloresBoton = listaColor,
            tamañoTexto = tamañoTexto,
            accion = accion
        )
    )
}


@Preview
@Composable
fun BotonPreview() {
    Column {
        AceptartBoton("Guardar")
        DenegartBoton("Salir")
    }
}