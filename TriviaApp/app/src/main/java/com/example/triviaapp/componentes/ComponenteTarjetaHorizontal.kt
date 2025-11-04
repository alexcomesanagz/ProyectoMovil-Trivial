package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.R

data class Tarjeta(val imagen: Int, val titulo: String, val accion: () -> Unit = {})

@Composable
fun ComponenteTarjetaHorizontal(contenido: Tarjeta) {

    Row(
        modifier = Modifier
            .clickable(onClick = contenido.accion)
            .background(color = MaterialTheme.colorScheme.background)
            .padding(horizontal = 2.dp, vertical = 2.dp)
            .fillMaxWidth()
    ) {
        ComponenteImagen(id = contenido.imagen)
        Text(
            text = contenido.titulo,
            modifier = Modifier.padding(horizontal = 6.dp)
        )
    }
}

@Composable
fun ComponenteTarjetaHorizontalCategoria(contenido: Tarjeta) {

    Row(
        modifier = Modifier
            .clickable(onClick = contenido.accion)
            .background(color = MaterialTheme.colorScheme.background)
            .padding(horizontal = 2.dp, vertical = 2.dp)
            .height(60.dp)
            .fillMaxWidth()
    ) {
        ComponenteImagen(id = contenido.imagen,60)
        Text(
            text = contenido.titulo,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 8.dp),
            fontSize = 32.sp

        )
    }
}

@Preview
@Composable
fun PrevioTarjHoriz() {
    val contenido = Tarjeta(R.drawable.trivia, "abuela")

    ComponenteTarjetaHorizontalCategoria(contenido)
}