package com.example.triviaapp.paginas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetasHorizontal
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.viewModels.PaginaListaUiState
import com.example.triviaapp.viewModels.PaginaListaViewModel

private val tarjetas: Map<String, List<Tarjeta>> = mapOf("miedo" to
   listOf(Tarjeta(R.drawable.trivia,"Trivia 1")) ,
    "susto" to
            listOf(Tarjeta(R.drawable.trivia,"Trivia 2")),
    "resusto" to
            listOf( Tarjeta(R.drawable.trivia,"Trivia 3")),
    "cagao" to  listOf(Tarjeta(R.drawable.trivia,"Trivia 4")))

/**
 * Pagina que muestra todos los trivias disponibles
 */
@Composable
fun PaginaLista(paginaListaViewModel: PaginaListaViewModel= viewModel()){
    val uiState by paginaListaViewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        tarjetas.forEach { it ->
            ComponenteTituloYListaTarjetasHorizontal(it.key,it.value)

        }
    }
}

@Preview
@Composable
fun PrevPaginaLista() {
    TriviaAppTheme {
        PaginaLista()
    }
}