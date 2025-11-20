package com.example.triviaapp.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteImagen
import com.example.triviaapp.componentes.ComponenteListaTarjetas
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.DenegartBoton
import com.example.triviaapp.componentes.Tarjeta

val tarjetasUsuario: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.trivia, titulo ="Trivia 1"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 2"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 3"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 4"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 5"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 6"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 7"),
    Tarjeta(R.drawable.trivia, titulo ="Trivia 8")
)

/**
 * pagina donde un usuario que inicio sesion mira sus datos de la cuenta
 */
@Composable
fun PaginaPerfil() {
    Column(verticalArrangement = Arrangement.spacedBy(space = 50.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.End
        )
        {
            Box(modifier = Modifier.weight(weight = 0.5f)) {
                Text(text = "")
            }
            Box(modifier = Modifier.weight(weight = 1f)) {
                DenegartBoton(msj = "salir", modifier = Modifier.fillMaxWidth())
            }
            Box(modifier = Modifier.weight(weight = 0.5f)) {
                Text(text = "")
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 50.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ComponenteImagen(id = R.drawable.trivia, tamaño = 120)
            ComponenteTitulo("nombre usuario")
            ComponenteTitulo("correo usuario")
        }
        Box(
            modifier = Modifier.padding(horizontal = 50.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
            contentAlignment = Alignment.Center
        )
        {
            ComponenteListaTarjetas(tarjetas = tarjetasUsuario, tamanioCaja = 350, tamanio = 50)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPerfil() {
    PaginaPerfil()
}