package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ComponenteBoton(Msg: String, modifier: Modifier = Modifier, coloresBoton: ArrayList<Color>, accion:()-> Unit){
    Box(modifier = modifier){
        Button(onClick = accion,
            colors = ButtonColors(
                containerColor = coloresBoton.get(0),
                contentColor = coloresBoton.get(1),
                disabledContainerColor = coloresBoton.get(2),
                disabledContentColor = coloresBoton.get(3),
            )) {
            Text(text = Msg)
        }
    }

}


@Preview
@Composable
fun BotonPreview(){
    val colorBoton = ArrayList<Color>()
    colorBoton.add(Color.Gray)
    colorBoton.add(Color.Blue)
    colorBoton.add(Color.Black)
    colorBoton.add(Color.Black)
    ComponenteBoton(Msg = "yuya", coloresBoton = colorBoton,accion = {})
}