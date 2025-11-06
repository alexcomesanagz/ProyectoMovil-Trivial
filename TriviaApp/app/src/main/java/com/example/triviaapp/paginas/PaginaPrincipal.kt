package com.example.triviaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.componentes.ComponenteFAB
import com.example.triviaapp.componentes.ComponenteListaTarjetas
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.TopBarComponent
import com.example.triviaapp.paginas.PaginaLista
import kotlinx.coroutines.launch

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

@Composable
fun PaginaPrincipal() {
    Box(
        Modifier
            .fillMaxSize()
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