package com.example.triviaapp.paginas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.ComponenteCajaDatosTrivia
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.DatosBotonDoble

/**
 * Pagina para introducir datos del trivia a crear
 */

@Composable
fun PaginaAjustesTrivia() {
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )
    Column(
        modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        ComponenteCajaDatosTrivia()
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            ComponenteLinea()
            BotonesAceptarDenegarLinea(
                datosBotones = DatosBotonDoble(
                    stringResource(R.string.app_bt_salir),
                    stringResource(R.string.app_bt_aceptar),
                    accionBoton1 = { Log.e("Testing", "Denegar boton cliqueado") },
                    accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") })
            )
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevPaginaAjustesTrivia() {
    PaginaAjustesTrivia()
}