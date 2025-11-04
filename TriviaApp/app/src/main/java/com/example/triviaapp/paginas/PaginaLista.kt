package com.example.triviaapp.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteFAB
import com.example.triviaapp.componentes.ComponenteListaTarjetas
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontalCategoria
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.TopBarComponent
import kotlinx.coroutines.launch

private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.trivia,"Trivia"),
    Tarjeta(R.drawable.trivia,"Trivia"),
    Tarjeta(R.drawable.trivia,"Trivia"),
    Tarjeta(R.drawable.trivia,"Trivia"))
@Composable
fun PaginaLista(){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarComponent(title = "nelsol") },
        floatingActionButton = {
            ComponenteFAB {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "Perfil")
                }
            }
        }) { innerPadding ->

        Box(Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.TopEnd) {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                ComponenteTarjetaHorizontalCategoria(tarjetas.get(0))
                ComponenteTarjetaHorizontalCategoria(tarjetas.get(1))
                ComponenteTarjetaHorizontalCategoria(tarjetas.get(2))
                ComponenteTarjetaHorizontalCategoria(tarjetas.get(3))
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