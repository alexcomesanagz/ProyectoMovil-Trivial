package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

/**
 * Barra de navegacion de los escafolds
 * @param title texto que estara en el centro
 * @param accionMenu acccion del menu al hacer click
 * @param accionLogin hacion que se hara al hacer click en el icono de login
 * @param accionCamara acccion del la barra de busqueda al hacer click
 * @param accionPerfil acccion del perfil al hacer click
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponenteTopBar(
    title: String,
    accionMenu: () -> Unit={},
    accionLogin:()->Unit={ Log.e("Testeo","inicio sesion cliqueada")},
    accionCamara: () -> Unit={ Log.e("Testeo","camara cliqueada")},
    accionPerfil: () -> Unit={Log.e("Testeo","perfil cliqueada")}
) {
    TopAppBar(
        title = { Text(text = title, textAlign = TextAlign.Center) },
        navigationIcon = {
            IconButton(onClick = accionMenu) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = accionLogin) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Search")
            }
            IconButton(onClick = accionCamara) {
                Icon(Icons.Default.Create, contentDescription = "Search")
            }
            IconButton(onClick = accionPerfil) {
                Icon(Icons.Default.AccountCircle, contentDescription = "More")
            }
        }
    )
}

@Preview
@Composable
fun PreviewTop(){
    ComponenteTopBar("Página 1",{},{},{})
}