package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun ComponenteColumnaTextoDobleFondo(msj1: String,msj2: String){
    Column(verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 100.dp)) {
        ComponenteTitulo(titulo = msj1)
        ComponenteTitulo(titulo = msj2)
    }
}

@Composable
fun ComponenteColumnaTextoUnFondo(msj1: String,msj2: String){
    Column(verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 100.dp)) {
        ComponenteTitulo(titulo = msj1)
        Text(text = msj2, modifier = Modifier.padding(vertical = 4.dp, horizontal = 20.dp)
            .fillMaxWidth(),
            textAlign = TextAlign.Center)
    }
}


@Preview (showSystemUi = true)
@Composable
fun PreviewColumnTexto(){
    Column {
ComponenteColumnaTextoDobleFondo("si","no")
        ComponenteColumnaTextoUnFondo("si","no")
    }
}