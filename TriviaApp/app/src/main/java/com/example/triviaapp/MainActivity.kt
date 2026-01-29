package com.example.triviaapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.componentes.ComponenteFAB
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.ComponenteTopBar
import com.example.triviaapp.vista.paginas.PaginaElegirRespuestas
import com.example.triviaapp.vista.paginas.PaginaPerfil
import com.example.triviaapp.vista.paginas.PaginaResponderPreguntas
import kotlinx.coroutines.launch

private val titulo: String = "Título de prueba"
private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.trivia, titulo = "Trivia 1"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 2"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 3"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 4"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 5"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 6"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 7"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 8"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 9"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 10"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 11"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 12"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 13"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 14"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 15"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 16"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 17"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 18"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 19"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 20"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 21")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val snackbarHostState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scopeDrawer = rememberCoroutineScope()

            TriviaAppTheme {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Spacer(Modifier.height(12.dp))
                            Text(
                                text = "Inicio",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        // Handle click
                                        Log.e("Testing", "Inicio cliqueado")
                                        scopeDrawer.launch { drawerState.close() }
                                    }
                                    .padding(16.dp)
                            )
                            Text(
                                text = "Categorias",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        // Handle click
                                        Log.e("Testing", "categorias cliqueado")
                                        scopeDrawer.launch { drawerState.close() }
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            ComponenteTopBar(
                                title = "Página de prueba",
                                accionMenu = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                })
                        },
                        floatingActionButton = {
                            ComponenteFAB {
                                scope.launch {
                                    snackbarHostState.showSnackbar(message = "Perfil")
                                }
                            }
                        }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.inverseSurface)
                        ) {
//                            PaginaAjustesTrivia()
//                            PaginaElegirRespuestas()
//                            PaginaFinTrivia()
//                            PaginaLista()
//                            PaginaLogin()
                            PaginaPerfil()
//                            PaginaPrincipal()
//                            PaginaResponderPreguntas()
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
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scopeDrawer = rememberCoroutineScope()

        TriviaAppTheme(darkTheme = false) {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Inicio",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    // Handle click
                                    Log.e("Testing", "Inicio cliqueado")
                                    scopeDrawer.launch { drawerState.close() }
                                }
                                .padding(16.dp)
                        )
                        Text(
                            text = "Categorias",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    // Handle click
                                    Log.e("Testing", "categorias cliqueado")
                                    scopeDrawer.launch { drawerState.close() }
                                }
                                .padding(16.dp)
                        )
                    }
                }
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        ComponenteTopBar(
                            title = "Página de prueba",
                            accionMenu = {
                                scope.launch {
                                    drawerState.open()
                                }
                            })
                    },
                    floatingActionButton = {
                        ComponenteFAB {
                            scope.launch {
                                snackbarHostState.showSnackbar(message = "Perfil")
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
//                        PaginaAjustesTrivia() // cambiar tamaño botones y cajas unificadas
                            PaginaElegirRespuestas()
//                            PaginaFinTrivia() //hacerlo mas bonito/visual(ej: poner imagen de felicidades)
//                            PaginaLista()
//                            PaginaLogin()
//                            PaginaPerfil()
//                            PaginaPrincipal()
//                            PaginaResponderPreguntas()
                    }
                }
            }
        }
    }
}