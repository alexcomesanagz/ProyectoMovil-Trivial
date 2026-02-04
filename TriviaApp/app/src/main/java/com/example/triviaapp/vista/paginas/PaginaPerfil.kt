package com.example.triviaapp.vista.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteImagenRedondeada
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponenteListaTarjetasVertical
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.DenegarBoton
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.viewModels.vm.PaginaPerfilViewModel

val tarjetasUsuario: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.trivia, titulo = "Trivia 1"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 2"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 3"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 4"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 5"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 6"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 7"),
    Tarjeta(R.drawable.trivia, titulo = "Trivia 8")
)

/**
 * pagina donde un usuario que inicio sesion mira sus datos de la cuenta
 */
@Composable
fun PaginaPerfil(
    paginaPerfilUi: PaginaPerfilViewModel = viewModel(),
    onItemClick: (String) -> Unit,
    onSalida:()->Unit
) {

    val uiState by paginaPerfilUi.uiState.collectAsState()

    LaunchedEffect(Unit) {
        paginaPerfilUi.cargaDatos()
    }

    Column(verticalArrangement = Arrangement.spacedBy(space = 50.dp)) {
        Box(
            modifier = Modifier.padding(horizontal = 50.dp),
        ) {
            Column(
                modifier = Modifier.padding(top = 40.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ComponenteImagenRedondeada(id = uiState.imagenPerfil, tamanio = 120)
                ComponenteTitulo(uiState.nombreUsuario)
                ComponenteTitulo(uiState.correoUsuario)
            }
        }
        Box(
            modifier = Modifier.padding(horizontal = 50.dp),
            contentAlignment = Alignment.Center
        )
        {
            ComponenteListaTarjetasVertical(
                tarjetas = uiState.tarjetasUsuario.map {
                    Tarjeta(it.imagen,
                        it.titulo,
                        {contenido ->
                            onItemClick(contenido)
                        },
                        it.id)
                },
                tamanioCaja = 220,
                tamanio = 50,
                )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ComponenteLinea(grosor = 8.dp)
            DenegarBoton(
                msj = "salir",
                modifier = Modifier.fillMaxWidth(),
                accion = onSalida)
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewPerfil() {
    PaginaPerfil(onItemClick = {}, onSalida = {})
}