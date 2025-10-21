package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ComponenteBoton(Msg: String,modifier: Modifier,accion:()-> Unit){
    Box(modifier = modifier.fillMaxSize().background(color = Color.Gray)){
        Button(onClick = accion) {
            Text(text = Msg)
        }
    }

}