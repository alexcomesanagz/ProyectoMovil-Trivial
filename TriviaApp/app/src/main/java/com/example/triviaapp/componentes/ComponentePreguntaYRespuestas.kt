package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComponentePreguntaYRespuestas(enunciado: String, textoBotonesRespuesta: List<String>){
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        ComponenteTitulo(enunciado)
        ComponenteRespuestas(textoBotonesRespuesta)
    }
}

@Preview(showSystemUi = true)
@Composable
fun prevComponentePreguntaYRespuestas(){
    val enunciado = " ¿La invasión de qué fortaleza por parte de los revolucionarios es considerada como el punto de inicio de la Revolución Francesa?"

    val textoBotonesRespuesta = listOf(
        "Respuesta 1",
        "Respuesta 2",
        "Respuesta 3",
        "Respuesta 4"
    )

    ComponentePreguntaYRespuestas(enunciado, textoBotonesRespuesta)
}