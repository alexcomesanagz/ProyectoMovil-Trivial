package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

/**
 * Componente con los ajustes para crear un trivia
 * @param txtBotones lista de textos con tipos de categoría
 * @param tamañoTexto tamaño de la letra de los botones
 */
@Composable
fun ComponenteCajaDatosTrivia() {
    val txtTitulo = "Tipo de categoría"
    val txtBotones: List<String> = listOf(
        stringResource(R.string.app_categoria1),
        stringResource(R.string.app_categoria2),
        stringResource(R.string.app_categoria3),
        stringResource(R.string.app_categoria4)
    )
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )
    val tamañoTexto = 12

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ComponentePreguntaYRespuestas(txtTitulo, txtBotones, 1)
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteTitulo(stringResource(R.string.app_titulo_nombreTrivia))
                ComponenteTextField()

            }
        }
        Column {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteTitulo(stringResource(R.string.app_titulo_tituloSlider))
                ComponenteSlider()
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteTitulo(stringResource(R.string.app_titulo_tituloSwitch))
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    ComponenteSwitch()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevComponenteCajaDatosTrivia() {
    ComponenteCajaDatosTrivia()
}