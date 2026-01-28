package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * barra con número del 1 al 20
 * llendo de 1 en 1
 * @param sliderPosition posicion del componente,
 * siendo esta 10 por defecto
 */
class DatosSlider(var estadoSlider: Float,val accionSlider: (Float)-> Float={1f})
@Composable
fun ComponenteSlider(
    datos: DatosSlider
  ){
//    var sliderPosition by remember { mutableStateOf(10f) }
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(text= "Número de preguntas: " + datos.estadoSlider,
            color = MaterialTheme.colorScheme.onBackground
        )
        Slider(
            value = datos.estadoSlider,
            onValueChange = { datos.estadoSlider = datos.accionSlider(it) },
            valueRange = 1f..20f,
            steps = 18,
            colors = SliderDefaults.colors(activeTrackColor = MaterialTheme.colorScheme.secondary)
        )
    }
}

@Preview
@Composable
fun PrevComponenteSlider(){
    ComponenteSlider(DatosSlider(1f))
}