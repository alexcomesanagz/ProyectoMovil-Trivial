package com.example.triviaapp.paginas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.componentes.BotonesAceptarDenegarLinea
import com.example.triviaapp.componentes.ComponenteBotonesHorizontal
import com.example.triviaapp.componentes.ComponenteCajaDatosTrivia
import com.example.triviaapp.componentes.ComponenteLinea
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.DatosBotonDoble

/**
 * Pagina para introducir datos del trivia a crear
 */

@Composable
fun PaginaAjustesTrivia() {
    val txtSalir = "Salir"
    val txtAceptar = "Aceptar"
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )
    Column(
        modifier = Modifier.padding(vertical = 40.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        BotonesAceptarDenegarLinea(datosBotones = DatosBotonDoble(txtSalir,
            txtAceptar,
            accionBoton1 = { Log.e("Testing", "Denegar boton cliqueado") },
            accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") }))
        ComponenteCajaDatosTrivia()
    }

}

@Preview(showSystemUi = true)
@Composable
fun PrevPaginaAjustesTrivia() {
    PaginaAjustesTrivia()
}