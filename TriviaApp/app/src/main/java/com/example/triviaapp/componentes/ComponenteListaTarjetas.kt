package com.example.triviaapp.componentes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun ComponenteListaTarjetasVertical(
    tarjetas: List<Tarjeta>,
    tamanioCaja: Int = 250,
    tamanio: Int = 20
) {

    Box(
        Modifier.background(
            MaterialTheme.colorScheme.primary,
            RoundedCornerShape(8.dp)
        )
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(all = (tamanio ).dp)
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

@Composable
fun ComponenteListaTarjetasHorizontal(
    tarjetas: List<Tarjeta>,
    tamanioCaja: Int = 100,
    tamanio: Int = 20
) {

    Box(
        Modifier.background(
            MaterialTheme.colorScheme.secondary,
            RoundedCornerShape(8.dp)
        )
    ) {

        LazyRow(
            modifier = Modifier
                .padding(all = (tamanio / 2).dp)
                .fillMaxWidth()
                .height(height = tamanioCaja.dp),
            horizontalArrangement = Arrangement.spacedBy((tamanio * 0.5).dp),
            verticalAlignment = Alignment.CenterVertically
            )
        {
            items(tarjetas) { tarjeta ->
                    ComponenteTarjetaVertical(contenido = tarjeta, tamanio = tamanio)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun prevComponenteListaTarjetas() {
    val tarjetas: List<Tarjeta> = listOf(
        Tarjeta(R.drawable.trivia, titulo ="ciruelita macuquita"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 2"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 3"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 4"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 5"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 6"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 7"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 8"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 9"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 10"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 11"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 12"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 13"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 14"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 15"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 16"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 17"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 18"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 19"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 20"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 21")
    )
    Column {
    ComponenteListaTarjetasVertical(tarjetas);
    ComponenteListaTarjetasHorizontal(tarjetas)
    }
}