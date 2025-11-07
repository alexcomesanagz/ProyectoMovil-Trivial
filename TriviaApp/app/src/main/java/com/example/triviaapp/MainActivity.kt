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
import com.example.triviaapp.paginas.PaginaLista
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
            val scopeSnackbar = rememberCoroutineScope()
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
                                        scopeDrawer.launch { drawerState.close() }
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                ) {
                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            topBar = { ComponenteTopBar(title = "nelsol") },
                            floatingActionButton = {
                                ComponenteFAB {
                                    scopeSnackbar.launch {
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
    //                        PaginaPrincipal()
    //                        PaginaLista()
    //                        PaginaResponderPreguntas()
    //                        PaginaPerfil()
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
                                    Log.e("Testing","Inicio cliqueado")
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
                                    Log.e("Testing","categorias cliqueado")
                                    scopeDrawer.launch { drawerState.close() }
                                }
                                .padding(16.dp)
                        )
                    }
                }
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { ComponenteTopBar(title = "nelsol",
                        onMenuClick = {
                            scope.launch {
                        drawerState.open()
                    }}) },
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
                    ) {
//                           PaginaPrincipal()
                            PaginaLista()
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