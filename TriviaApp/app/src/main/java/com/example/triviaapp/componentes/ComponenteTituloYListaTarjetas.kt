package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

/**
 * crea una lista de tarjetas bajo un texto
 * @param titulo mensaje de el texto de encima de la lista
 * @param
 */
@Composable
fun ComponenteTituloYListaTarjetas(
    titulo: String,
    tarjetas: List<Tarjeta>
) {
    Column(modifier = Modifier.padding(vertical = 6.dp, horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        ComponenteTitulo(titulo)
        ComponenteListaTarjetas(tarjetas)
    }
}

@Preview(showSystemUi = true)
@Composable
fun prevComponenteTituloYListaTarjetas(){

    val titulo = "Título de prueba"

    val tarjetas: List<Tarjeta> = listOf(
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,titulo ="Abuela")
    )

    ComponenteTituloYListaTarjetas(titulo, tarjetas)
}