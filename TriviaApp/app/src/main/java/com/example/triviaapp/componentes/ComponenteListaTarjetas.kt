package com.example.triviaapp.componentes


import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

@Composable
fun ComponenteListaTarjetas(tarjetas: List<Tarjeta>) {

    Box(Modifier.background(
        MaterialTheme.colorScheme.secondary,
        RoundedCornerShape(8.dp))) {

        LazyColumn(
            modifier = Modifier.padding(8.dp)
                .fillMaxWidth()
                .height(250.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        )
        {
            items(tarjetas) { tarjeta ->
                ComponenteTarjetaHorizontal(tarjeta)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun prevComponenteListaTarjetas() {
    val tarjetas: List<Tarjeta> = listOf(
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
        Tarjeta(R.drawable.ic_launcher_background,"Abuela")
    )
    ComponenteListaTarjetas(tarjetas);
}