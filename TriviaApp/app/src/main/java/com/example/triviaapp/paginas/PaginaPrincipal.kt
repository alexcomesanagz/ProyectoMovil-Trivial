package com.example.triviaapp.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteFAB
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.TopBarComponent
import kotlinx.coroutines.launch

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
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarComponent(title = "nelsol")},
            floatingActionButton = {
                ComponenteFAB {
                    scope.launch {
                        snackbarHostState.showSnackbar( message = "Perfil")
                    }
                }
            }) { innerPadding ->

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