package com.example.triviaapp.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
 * @param tamanio el tamaño de la imagen, por defecto a 20
 */
@Composable
fun ComponenteImagen(
    id: Int,
    tamanio: Int = 20
) {

    Image(
        painter = painterResource(id = id),
        modifier = Modifier
            .size(width = tamanio.dp, height = tamanio.dp)
            .padding(vertical = 2.dp, horizontal = 2.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        contentDescription = "imagen categoria"
    )

}

@Composable
fun ComponenteImagenRedondeada(
    id: Int,
    tamanio: Int = 20
) {

    Image(
        painter = painterResource(id = id),
        modifier = Modifier
            .size(width = tamanio.dp, height = tamanio.dp)
            .clip(shape = CircleShape),
        contentDescription = "imagen categoria"
    )

}

@Preview
@Composable
fun ImagenPreview() {
    ComponenteImagen(R.drawable.trivia)
}

@Preview
@Composable
fun ImagenPreviewRedondeada() {
    ComponenteImagenRedondeada(R.drawable.trivia)
}