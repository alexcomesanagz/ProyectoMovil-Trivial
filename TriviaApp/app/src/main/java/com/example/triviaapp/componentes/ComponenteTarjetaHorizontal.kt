package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

data class Tarjeta(val imagen: Int, val titulo: String)
@Composable
fun ComponenteTarjetaHorizontal(contenido: Tarjeta,accion:()-> Unit){

    Row(modifier = Modifier.clickable(onClick = accion).background(color = Color.White).padding(horizontal = 2.dp, vertical = 2.dp)) {
        Image(painter = painterResource(id = contenido.imagen), modifier = Modifier.size(width = 20.dp, height = 20.dp),contentDescription = "imagen categoria")
        Text(text = contenido.titulo , modifier = Modifier.padding(horizontal = 6.dp))
    }

}

@Preview
@Composable
fun PrevioTarjHoriz(){
    val contenido = Tarjeta(R.drawable.ic_launcher_background, "abuela")

    ComponenteTarjetaHorizontal(contenido,{})
}