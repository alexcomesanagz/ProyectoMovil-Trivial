package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @param msj1 mensaje del primer texto
 * @param msj2 mensaje del segundo texto
 * @param tamanio tamaño que tendran los textos
 */
class DatosColumnaTexto(
    var msj1: String,
    var msj2: String,
    var tamanio: Int = 15
)

/**
 * genera dos textos en columna con el mismo fondo
 */
@Composable
fun ComponenteColumnaTextoDobleFondo(datos: DatosColumnaTexto) {
    Column(
        verticalArrangement = Arrangement.spacedBy((datos.tamanio / 3).dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        ComponenteTituloCaja(titulo = datos.msj1, tamanio = datos.tamanio)
        ComponenteTituloCaja(titulo = datos.msj2, tamanio = datos.tamanio)
    }
}

/**
 * genera dos textos en columna, uno con fondo y otro sin el
 */
@Composable
fun ComponenteColumnaTextoUnFondo(datos: DatosColumnaTexto) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        ComponenteTituloCaja(titulo = datos.msj1, tamanio = datos.tamanio)
        Box(
            modifier = Modifier
                .background(
                MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    )
            ),

            ) {
            Text(
                text = datos.msj2,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = (datos.tamanio/3).dp)
                    .fillMaxWidth(),
                fontSize = datos.tamanio.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewColumnTexto() {
    Column(verticalArrangement = Arrangement.spacedBy(40.dp)) {
        ComponenteColumnaTextoDobleFondo(datos = DatosColumnaTexto("Guardar", "Salir"))
        ComponenteColumnaTextoUnFondo(DatosColumnaTexto("Guardar", "Salir", 30))
    }
}