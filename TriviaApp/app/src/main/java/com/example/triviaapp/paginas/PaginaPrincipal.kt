package com.example.triviaapp.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.TopBarComponent

private val titulo: String = "Título de prueba"
private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela")
)

@Composable
fun PaginaPrincipal(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarComponent(title = "nelsol") }) { innerPadding ->

        Box(Modifier.fillMaxSize().padding(innerPadding)) {
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                ComponenteTituloYListaTarjetas(titulo, tarjetas)
                ComponenteTituloYListaTarjetas(titulo, tarjetas)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevPaginaPrinc() {
    TriviaAppTheme {
        PaginaPrincipal()
    }
}