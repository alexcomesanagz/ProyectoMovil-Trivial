package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.R

data class Tarjeta(val imagen: Int, val titulo: String, val accion: () -> Unit = { Log.e("Testing","Tarjeta clicada")})

@Composable
fun ComponenteTarjetaHorizontal(tarjeta: Tarjeta, tamanio: Int=40) {

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = tarjeta.accion)
            .background(color = MaterialTheme.colorScheme.background)
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .height(height = (tamanio*1.25).dp)
            .fillMaxWidth()
    ) {
        ComponenteImagen(id = tarjeta.imagen, tamaño = tamanio)
        Text(
            text = tarjeta.titulo,
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp),
            fontSize = (tamanio*0.5).sp

        )
    }
}



@Preview
@Composable
fun PrevioTarjHoriz() {
    val contenido = Tarjeta(R.drawable.trivia, titulo = "abuela")

    ComponenteTarjetaHorizontal(contenido)
}