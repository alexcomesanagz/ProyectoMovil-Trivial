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
fun ComponenteBoton(Msg: String, modifier: Modifier = Modifier, accion:()-> Unit){
    Box(modifier = modifier.fillMaxSize()){
        Button(onClick = accion,
            colors = ButtonColors(
                containerColor = Color.Gray,
                contentColor = Color.White,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Black,
            )) {
            Text(text = Msg)
        }
    }

}


@Preview
@Composable
fun BotonPreview(){
    ComponenteBoton(Msg = "yuya", accion = {})
}