package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComponenteTitulo(titulo: String){
    Text(text = titulo,
        modifier = Modifier.background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp))
            .padding(vertical = 4.dp, horizontal = 20.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun prevComponenteTitulo(){
    val titulo = "Título de prueba"
    ComponenteTitulo(titulo)
}