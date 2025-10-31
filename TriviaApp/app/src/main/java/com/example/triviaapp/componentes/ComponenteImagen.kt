package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
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
fun ComponenteImagen(id: Int,tamaño: Int=20) {

    Image(
        painter = painterResource(id = id),
        modifier = Modifier.size(width = tamaño.dp, height = tamaño.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(vertical = 2.dp, horizontal = 2.dp),
        contentDescription = "imagen categoria"
    )

}

@Preview
@Composable
fun ImagenPreview(){
    ComponenteImagen(R.drawable.ic_launcher_background)
}