package com.example.triviaapp.componentes

package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.paginas.txtTitulo

/**
 * Componente que combina un titulo con un componente cualquiera
 * @param txtTitulo texto que le llega para poner de titulo,
 * @param componente es un componente que le mandes
 */
@Composable
fun ComponenteTituloComponente(txtTitulo: String, componente: @Composable () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(txtTitulo)
        componente()
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevComponenteTituloComponente() {
    val txtTitulo = "Slider"

    ComponenteTituloComponente(txtTitulo, ComponenteSlider())
}