package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.triviaapp.R

@Composable
fun ComponenteTarjetaHorizontal(imagen: Int,TxtMsg: String,accion:()-> Unit){

    Row(modifier = Modifier.clickable(onClick = accion)) {
        Image(painter = painterResource(id = imagen),contentDescription = "imagen categoria")
        Text(text = TxtMsg)
    }

}

@Preview
@Composable
fun PrevioTarjHoriz(){
    val imagen= R.drawable.ic_launcher_background
    ComponenteTarjetaHorizontal(imagen,"abuela",{})
}