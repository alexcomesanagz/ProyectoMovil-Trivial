package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DatosRadioBoton(
    val msj: String,
    val boton:String,
    val coloresBoton: List<Color>,
    val tamanioTexto:Int=12,
    var rememberCadena: String ="",
    var accion: (String) -> String = {" "}
)


@Composable
fun ComponenteRadioButon(
    datos: DatosRadioBoton
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.secondary,
                RoundedCornerShape(25.dp)
            )
            .fillMaxWidth()
            .clickable {
               datos.rememberCadena= datos.accion(datos.boton)
            }
            ,
        horizontalArrangement = Arrangement.Center
    ){
        RadioButton(
            selected = (datos.boton== datos.rememberCadena),
            colors = RadioButtonColors(
                selectedColor = datos.coloresBoton.get(0),
                unselectedColor = datos.coloresBoton.get(0),
                disabledSelectedColor = datos.coloresBoton.get(1),
                disabledUnselectedColor =    datos.coloresBoton.get(2)
            ),
            onClick = { datos.rememberCadena = datos.accion(datos.boton) },
            modifier = Modifier
        )
        Text(
            modifier = Modifier.padding(end = 10.dp),
            text = datos.msj,
            fontSize = datos.tamanioTexto.sp,
            textAlign = TextAlign.Center,
            color = datos.coloresBoton.get(0)
        )

    }
}
