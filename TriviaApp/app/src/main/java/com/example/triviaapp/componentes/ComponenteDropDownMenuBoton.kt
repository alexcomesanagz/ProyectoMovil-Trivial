package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import com.example.triviaapp.R


/**
 * Muestra trivias de una categoría al ser clicado
 * @param
 */


@Composable
fun ComponenteDropDownMenuBoton() {

    val tarjetas: List<Tarjeta> = listOf(
        Tarjeta(R.drawable.trivia, "Trivia 1"),
        Tarjeta(R.drawable.trivia, "Trivia 2"),
        Tarjeta(R.drawable.trivia, "Trivia 3"),
        Tarjeta(R.drawable.trivia, "Trivia 4"),
        Tarjeta(R.drawable.trivia, "Trivia 5"),
        Tarjeta(R.drawable.trivia, "Trivia 7"),
        Tarjeta(R.drawable.trivia, "Trivia 8"),
        Tarjeta(R.drawable.trivia, "Trivia 9"),
        Tarjeta(R.drawable.trivia, "Trivia 10"),
        Tarjeta(R.drawable.trivia, "Trivia 11")
    )

    var expanded by remember { mutableStateOf(false) }
    val contenido = Tarjeta(R.drawable.trivia, titulo = "Trivia 1", { expanded = !expanded })

    ComponenteTarjetaHorizontal(tarjeta = contenido)

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        tarjetas.forEach { tarjeta ->
            DropdownMenuItem(
                { ComponenteTarjetaHorizontal(tarjeta) },
                onClick = {},
                modifier = Modifier.fillMaxSize()

                )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevComponenteDropDownMenuBoton() {
    ComponenteDropDownMenuBoton()
}