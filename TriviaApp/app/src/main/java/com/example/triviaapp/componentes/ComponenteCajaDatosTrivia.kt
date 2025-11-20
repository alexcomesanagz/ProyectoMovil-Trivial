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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.paginas.txtTitulo

/**
 * Componente con los ajustes para crear un trivia
 * @param txtTitulo texto de categoría
 * @param txtBotones lista de textos con tipos de categoría
 * @param tamañoTexto tamaño de la letra de los botones
 * @param txtTextField texto del nombre trivial
 * @param txtSlider texto del número de preguntas
 * @param txtSwitch texto de si mostrar creador
 */
@Composable
fun ComponenteCajaDatosTrivia() {
    val txtTitulo = "Tipo de categoría"
    val txtBotones: List<String> = listOf(
        "Terror",
                "Accion",
                "Puzzle",
                "Tactico"
    )
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )
    val txtTextField = "Nombre trivial"
    val txtSlider = "Número de preguntas"
    val txtSwitch = "Mostrar creador"
    val tamañoTexto = 12

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column() {
           ComponenteTituloConBotonesHorizontal(txtTitulo, txtBotones,
               tamañoTexto = tamañoTexto,
               accionBotones = accionbotones)
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                ComponenteTitulo(txtTextField)
                ComponenteTextField()

            }
        }
        Column {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteTitulo(txtSlider)
                ComponenteSlider()
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ComponenteTitulo(txtSwitch)
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