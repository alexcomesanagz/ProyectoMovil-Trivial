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
 * 
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponenteTopBar(
    title: String,
    onMenuClick: () -> Unit={},
    onSearchClick: () -> Unit={ Log.e("Testeo","camara cliqueada")},
    onMoreClick: () -> Unit={Log.e("Testeo","perfil cliqueada")}
) {
    TopAppBar(
        title = { Text(text = title, textAlign = TextAlign.Center) },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Search")
            }
            IconButton(onClick = onSearchClick) {
                Icon(Icons.Default.Create, contentDescription = "Search")
            }
            IconButton(onClick = onMoreClick) {
                Icon(Icons.Default.AccountCircle, contentDescription = "More")
            }
        }
    )
}

@Preview
@Composable
fun PreviewTop(){
    ComponenteTopBar("awa",{},{},{})
}