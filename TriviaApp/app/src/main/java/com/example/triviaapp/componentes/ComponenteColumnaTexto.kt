package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ComponenteColumnaTexto(msj1: String,msj2: String){
    Column(verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 100.dp)) {
        ComponenteTitulo(titulo = msj1)
        ComponenteTitulo(titulo = msj2)
    }
}
@Preview (showSystemUi = true)
@Composable
fun PreviewColumnTexto(){
ComponenteColumnaTexto("si","no")
}