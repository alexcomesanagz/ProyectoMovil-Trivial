package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

@Composable
fun ComponenteImagen(id: Int) {

    Image(
        painter = painterResource(id = id),
        modifier = Modifier.size(width = 20.dp, height = 20.dp).clip(shape = RoundedCornerShape(10.dp)),
        contentDescription = "imagen categoria"
    )

}

@Preview
@Composable
fun ImagenPreview(){
    ComponenteImagen(R.drawable.ic_launcher_background)
}