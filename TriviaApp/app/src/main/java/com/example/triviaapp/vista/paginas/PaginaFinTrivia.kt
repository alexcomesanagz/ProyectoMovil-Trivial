package com.example.triviaapp.vista.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.ComponenteColumnaTextoUnFondo
import com.example.triviaapp.componentes.ComponenteCreditoCreadores
import com.example.triviaapp.componentes.ComponenteImagen
import com.example.triviaapp.componentes.DatosColumnaTexto
import com.example.triviaapp.componentes.DenegarBoton
import com.example.triviaapp.viewModels.PaginaFinViewModel

/**
 * Pagina que muestra los resultados del trivia hecho
 */
@Composable
fun PaginaFinTrivia(
    idTrivia: String,
    paginaFinViewModel: PaginaFinViewModel = viewModel(),
    accionSalir: ()->Unit
) {
    val uiState by paginaFinViewModel.uiState.collectAsState()

    LaunchedEffect(idTrivia) {
        paginaFinViewModel.cargar(idTrivia)
        paginaFinViewModel.cambioImagen()
    }


    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(space = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(space = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 30.dp)
        ) {
            ComponenteColumnaTextoUnFondo(
                DatosColumnaTexto(
                    msj1 = stringResource(R.string.app_titulo_tituloPreguntasAcertadas),
                    msj2 = "" + uiState.preguntasAcertadas + "/" + uiState.preguntasTotales,
                    tamaño = 30
                )
            )
        }
        ComponenteImagen(uiState.imagenResultado, 300)
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(weight = 0.5f)
                    .fillMaxWidth()
            ) {
                Text(text = "")
            }
            Box(
                modifier = Modifier
                    .weight(weight = 1f)
                    .fillMaxWidth()
            ) {
                DenegarBoton(
                    stringResource(R.string.app_bt_salir),
                    modifier = Modifier.fillMaxWidth(),
                    accion = accionSalir
                )
            }

            Box(
                modifier = Modifier
                    .weight(weight = 0.5f)
                    .fillMaxWidth()
            ) {
                Text(text = "")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFinTrivia() {
    PaginaFinTrivia("", accionSalir = {})
}