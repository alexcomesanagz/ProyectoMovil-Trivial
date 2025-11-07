package com.example.triviaapp.paginas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.Tarjeta

private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.trivia,"Abuela"),
    Tarjeta(R.drawable.trivia,"Abuela"),
    Tarjeta(R.drawable.trivia,"Abuela"),
    Tarjeta(R.drawable.trivia,"Abuela"))

/**
 * 
 */
@Composable
fun PaginaLista(){
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComponenteTarjetaHorizontal(tarjetas.get(0), tamanio = 80)
            ComponenteTarjetaHorizontal(tarjetas.get(1), tamanio = 80)
            ComponenteTarjetaHorizontal(tarjetas.get(2), tamanio = 80)
            ComponenteTarjetaHorizontal(tarjetas.get(3), tamanio = 80)
        }
    }

@Preview
@Composable
fun PrevPaginaLista() {
    TriviaAppTheme {
        PaginaLista()
    }
}