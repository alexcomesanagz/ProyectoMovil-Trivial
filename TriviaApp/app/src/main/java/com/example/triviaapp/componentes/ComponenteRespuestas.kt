package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
fun ComponenteRespuestas(botonesRespuestas: ArrayList<Boton>) {
    Box() {
        Column() {
            ComponenteBoton(botonesRespuestas) { }
            ComponenteBoton(botonesRespuestas) { }
            Row {
                ComponenteBoton(botonesRespuestas) { }
                ComponenteBoton(botonesRespuestas) { }
            }
        }
    }
}