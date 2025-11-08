package com.example.triviaapp.componentes

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
 * Componente con dos estados
 * cuando lo pulsas cambia de estado
 * @param isChecked estado del componente,
 * siendo este false por defecto
 */
@Composable
fun ComponenteCajaDatosTrivia() {
    val txtTitulo = "Tipo de categoría"
    val txtBotones: List<String> = listOf(
        "Categoría 1" +
                "Categoría 2" +
                "Categoría 3" +
                "Categoría 4"
    )
    val txtTextField = "Nombre trivial"
    val txtSlider = "Número de preguntas"
    val txtSwitch = "Mostrar creador"


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column() {
//            ComponenteTituloConBotonesHorizontal(txtTitulo, txtBotones)
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
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