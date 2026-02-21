package com.example.triviaapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetasHorizontal
import com.example.triviaapp.viewModels.vm.PrincipalViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.componentes.Tarjeta


/**
 * Pagina que muestra unos trivias recomendados y ultimos trivias
 */
@Composable
fun PaginaPrincipal(principalViewmodel: PrincipalViewModel = viewModel(), onItemClick: (String) -> Unit) {
    LaunchedEffect(Unit) {
        principalViewmodel.cargaDatos()
    }
    val uiState by principalViewmodel.uiState.collectAsState()

    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            ComponenteTituloYListaTarjetasHorizontal(
                stringResource(R.string.app_titulo_pagina_1),
                uiState.tarjetasLista1.map {
                    Tarjeta(it.imagen,
                        it.titulo,
                        {
                            onItemClick(it.id)
                        }
                       )
                }
            )
            ComponenteTituloYListaTarjetasHorizontal(
                stringResource(R.string.app_titulo_pagina_2),
                uiState.tarjetasLista2.map {
                    Tarjeta(it.imagen,
                        it.titulo,
                        {
                            onItemClick(it.id)
                        }
                    )
                })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun prevPaginaPrincipal() {
    PaginaPrincipal(onItemClick = {""})

}