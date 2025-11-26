package com.example.triviaapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta
private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.trivia, titulo ="Trivia 1"),
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

/**
 * Pagina que muestra unos trivias recomendados y ultimos trivias
 */
@Composable
fun PaginaPrincipal() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            ComponenteTituloYListaTarjetas(stringResource(R.string.app_titulo_pagina_1),
                tarjetas)
            ComponenteTituloYListaTarjetas(stringResource(R.string.app_titulo_pagina_2),
                tarjetas)
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