package com.example.triviaapp.vista.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetasHorizontal
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.viewModels.vm.PaginaListaViewModel

/**
 * Pagina que muestra todos los trivias disponibles
 */
@Composable
fun PaginaLista(paginaListaViewModel: PaginaListaViewModel= viewModel()){

    val uiState by paginaListaViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(30.dp)) {

            items(items =uiState.mapaDatos.entries.toList(), key = {it.key} ){ entry ->
                ComponenteTituloYListaTarjetasHorizontal(entry.key,entry.value)
            }
        }
    }
}


@Preview
@Composable
fun PrevPaginaLista() {
        PaginaLista()

}