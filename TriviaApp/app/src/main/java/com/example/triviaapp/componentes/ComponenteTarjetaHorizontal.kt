package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun ComponenteTarjetaHorizontal(imagen: Int,TxtMsg: String,accion:()-> Unit){

    Row {
        Image(painter = painterResource(id = imagen),contentDescription = "imagen categoria")
        Text(text = TxtMsg)
    }

}