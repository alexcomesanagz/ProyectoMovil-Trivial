package com.example.triviaapp.paginas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.AceptartBoton
import com.example.triviaapp.componentes.BotonesDobleAceptarColumna
import com.example.triviaapp.componentes.ComponenteFAB
import com.example.triviaapp.componentes.ComponenteImagen
import com.example.triviaapp.componentes.ComponenteListaTarjetas
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontalCategoria
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.DenegartBoton
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.componentes.TopBarComponent
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent
import kotlin.math.sign
val tarjetasPerfil: List<Tarjeta> = listOf(
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
@Composable
fun PaginaPerfil() {

    Box(
        Modifier
            .fillMaxSize()
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(space = 30.dp),
            modifier = Modifier.padding( horizontal = 40.dp),
        ) {
            Row(horizontalArrangement = Arrangement.End) {
                DenegartBoton("salir")
            }
            Column(verticalArrangement = Arrangement.spacedBy(space = 35.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                ComponenteImagen(R.drawable.trivia)
                ComponenteTitulo("aya")
                ComponenteTitulo("aya")
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(space = 35.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ComponenteListaTarjetas(tarjetasPerfil)
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewPaginaPerfil(){
    TriviaAppTheme {
        PaginaPerfil()
    }
}
