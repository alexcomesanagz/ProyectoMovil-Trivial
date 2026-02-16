package com.example.triviaapp.vista.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.ComponenteCajaDatosTrivia
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.DatosBotonDoble
import com.example.triviaapp.viewModels.vm.PaginaAjustesViewModel

/**
 * Pagina para introducir datos del trivia a crear
 */

@Composable
fun PaginaAjustesTrivia(paginaAjustesUi: PaginaAjustesViewModel = viewModel(), onClickSalir: () -> Unit, onClickAceptar: (String) -> Unit ) {
    val uiState by paginaAjustesUi.uiState.collectAsState()
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp, horizontal = 10.dp)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            ComponenteCajaDatosTrivia(
                estadoSlider = uiState.preguntas.toFloat(),
                accionSlider = { paginaAjustesUi.setPreguntas(it) },
                cadenaField = uiState.nombreTriv,
                accionTextField = { paginaAjustesUi.setNombreTrivia(it) },
                radioButonSeleccionado = uiState.categoria,
                accionRadioButons = { paginaAjustesUi.setCategoria(it) })
            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                ComponenteLinea()
                BotonesAceptarDenegarLinea(
                    datosBotones = DatosBotonDoble(
                        stringResource(R.string.app_bt_salir),
                        stringResource(R.string.app_bt_aceptar),
                        accionBoton1 = onClickSalir,
                        accionBoton2 = {
                            paginaAjustesUi.crearTrivia(
                                onSucces = {it->onClickAceptar(it)},
                                onError = {}
                            )
                        }
                    )
                )
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevPaginaAjustesTrivia() {
    PaginaAjustesTrivia(onClickSalir = {""},onClickAceptar = {""})
}