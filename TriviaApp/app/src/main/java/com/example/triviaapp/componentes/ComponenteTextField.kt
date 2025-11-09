package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Componente para introducir textos
 * @param txtContenido texto que aparece antes de introducir un texto
 * @param txtNuevo texto introducido empleado para actualizar
 */
@Composable
fun ComponenteTextField(msjPregunta:String="Introduca aquí nombre del Trivial a crear"){
    val txtContenido = remember { mutableStateOf("") }
    TextField(
        value = txtContenido.value,
        onValueChange = { txtNuevo ->
            txtContenido.value = txtNuevo
        },
        label = { Text(msjPregunta) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun PrevComponenteTextField(){
    ComponenteTextField()
}