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

/**
 * Crea una imagen de la id de la imagen que se le pase
 * @param id la imagen que se quiere que aparezca
 * @param tamaño el tamaño de la imagen, por defecto a 20
 */
@Composable
fun ComponenteImagen(
    id: Int,
    tamaño: Int = 20
) {

    Image(
        painter = painterResource(id = id),
        modifier = Modifier
            .size(width = tamaño.dp, height = tamaño.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(vertical = 2.dp, horizontal = 2.dp),
        contentDescription = "imagen categoria"
    )

}

@Preview
@Composable
fun ImagenPreview() {
    ComponenteImagen(R.drawable.trivia)
}