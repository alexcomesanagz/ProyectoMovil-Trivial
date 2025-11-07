package com.example.triviaapp.componentes

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

/**
 * Componente con dos estados
 * cuando lo pulsas cambia de estado
 * con estado false por defecto
 */
@Composable
fun ComponenteSwitch(){
    var isChecked by remember { mutableStateOf(false) }
    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it}
    )
}

@Preview
@Composable
fun PrevComponenteSwitch(){
    ComponenteSwitch()
}