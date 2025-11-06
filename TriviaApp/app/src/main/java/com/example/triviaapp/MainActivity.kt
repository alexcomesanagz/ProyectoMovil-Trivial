package com.example.triviaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
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
import com.example.triviaapp.paginas.PaginaElegirRespuestas
import com.example.triviaapp.paginas.PaginaLista
import com.example.triviaapp.paginas.PaginaLogin
import com.example.triviaapp.paginas.PaginaPerfil
import com.example.triviaapp.paginas.PaginaResponderPreguntas
import kotlinx.coroutines.launch

private val titulo: String = "Título de prueba"
private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela"),
    Tarjeta(R.drawable.ic_launcher_background, titulo ="Abuela")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()

            TriviaAppTheme {
                Column {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopBarComponent(title = "nelsol") },
                        floatingActionButton = {
                            ComponenteFAB {
                                scope.launch {
                                    snackbarHostState.showSnackbar( message = "Perfil")
                                }
                            }
                        }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        ){
//                        PaginaPrincipal()
//                        PaginaLista()
//                        PaginaResponderPreguntas()
                          PaginaPerfil()
                        }
                    }
                }
            }
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun prevPagina() {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        TriviaAppTheme {
            Column {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBarComponent(title = "nelsol") },
                    floatingActionButton = {
                        ComponenteFAB {
                            scope.launch {
                                snackbarHostState.showSnackbar( message = "Perfil")
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.inverseSurface)
                    ){
//                           PaginaPrincipal()
//                            PaginaLista()
//                            PaginaLogin()
//                            PaginaResponderPreguntas()
//                            PaginaElegirRespuestas()
//                            PaginaPerfil()
                    }
                }
            }
        }
    }
}