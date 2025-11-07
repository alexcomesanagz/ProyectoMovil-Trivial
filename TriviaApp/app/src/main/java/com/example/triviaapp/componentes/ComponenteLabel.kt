package com.example.triviaapp.componentes

import androidx.compose.runtime.*
import androidx.compose.material3.*

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

/**
 * Componente para introducir textos
 * @param txtContenido texto que aparece antes de introducir un texto
 * @param txtNuevo texto introducido empleado para actualizar
 */
@Composable
fun ComponenteLabel(){
    val txtContenido = remember { mutableStateOf("") }
    TextField(
        value = txtContenido.value,
        onValueChange = { txtNuevo ->
            txtContenido.value = txtNuevo
        },
        label = { Text("Introduca aquí nombre del Trivial a crear") }
    )
}

@Preview
@Composable
fun PrevComponenteLabel(){
    ComponenteLabel()
}