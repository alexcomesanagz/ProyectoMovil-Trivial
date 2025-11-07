package com.example.triviaapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta

private val titulo: String = "Título de prueba"
private val tarjetas: List<Tarjeta> = listOf(
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
    Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, "Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, "Abuela")
)

/**
 * Pagina que muestra unos trivias recomendados y mas populares
 */
@Composable
fun PaginaPrincipal() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            ComponenteTituloYListaTarjetas(titulo, tarjetas)
            ComponenteTituloYListaTarjetas(titulo, tarjetas)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun prevPaginaPrincipal() {
    TriviaAppTheme {
        PaginaPrincipal()
    }
}