package com.example.triviaapp.componentes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

/**
 * crea una lista de trajetas que se puede escrolear de manera vertical
 * @param tarjetas tarjetas que aparecerán en la lista
 * @param tamanioCaja la altura que tendrá donde se contiene la lista
 * @param tamanio tamaño de las tarjetas de dentro de la lista
 */
@Composable
fun ComponenteListaTarjetas(
    tarjetas: List<Tarjeta>,
    tamanioCaja: Int = 250,
    tamanio: Int = 20
) {

    Box(
        Modifier.background(
            MaterialTheme.colorScheme.secondary,
            RoundedCornerShape(8.dp)
        )
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(all = (tamanio / 1.8).dp)
                .fillMaxWidth()
                .height(height = tamanioCaja.dp),
            verticalArrangement = Arrangement.spacedBy((tamanio * 0.5).dp)
        )
        {
            items(tarjetas) { tarjeta ->
                ComponenteTarjetaHorizontal(contenido = tarjeta, tamanio = tamanio)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun prevComponenteListaTarjetas() {
    val tarjetas: List<Tarjeta> = listOf(
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
        Tarjeta(R.drawable.ic_launcher_background, "Abuela")
    )
    ComponenteListaTarjetas(tarjetas);
}