package com.example.triviaapp.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.TopBarComponent

val contenido =listOf<Tarjeta>(
    Tarjeta(R.drawable.ic_launcher_background, "abuela"),
    Tarjeta(R.drawable.ic_launcher_background, "abuela"),
    Tarjeta(R.drawable.ic_launcher_background, "abuela"),
    Tarjeta(R.drawable.ic_launcher_background, "abuela"))

@Composable
fun PaginaLista(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarComponent(title = "nelsol") }) { innerPadding ->

        Box(Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.TopEnd) {
            Column(verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)) {
                ComponenteTarjetaHorizontal(contenido = contenido.get(0))
                ComponenteTarjetaHorizontal(contenido = contenido.get(1))
                ComponenteTarjetaHorizontal(contenido = contenido.get(2))
                ComponenteTarjetaHorizontal(contenido = contenido.get(3))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevPaginaLista() {
    TriviaAppTheme {
        PaginaLista()
    }
}