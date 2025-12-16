package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

/**
 * crea una lista de tarjetas bajo un texto
 * @param titulo mensaje de el texto de encima de la lista
 * @param tarjetas lista de tarjetas que estaran en la lista
 */
@Composable
fun ComponenteTituloYListaTarjetasVertical(
    titulo: String,
    tarjetas: List<Tarjeta>
) {
    Column(modifier = Modifier.padding(vertical = 6.dp, horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        ComponenteTitulo(titulo)
        ComponenteListaTarjetasVertical(tarjetas)
    }
}
@Composable
fun ComponenteTituloYListaTarjetasHorizontal(
    titulo: String,
    tarjetas: List<Tarjeta>
) {
    Column(modifier = Modifier.padding(vertical = 6.dp, horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        ComponenteTitulo(titulo)
        ComponenteListaTarjetasHorizontal(tarjetas)
    }
}

@Preview(showSystemUi = true)
@Composable
fun prevComponenteTituloYListaTarjetas(){

    val titulo = "Título de prueba"

    val tarjetas: List<Tarjeta> = listOf(
        Tarjeta(R.drawable.trivia, titulo ="Trivia 1"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 2"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 3"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 4"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 5"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 6"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 7"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 8"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 9"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 10"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 11"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 12"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 13"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 14"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 15"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 16"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 17"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 18"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 19"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 20"),
        Tarjeta(R.drawable.trivia, titulo ="Trivia 21")
    )
    Column {
    ComponenteTituloYListaTarjetasVertical(titulo, tarjetas)
    ComponenteTituloYListaTarjetasHorizontal(titulo,tarjetas)
    }
}