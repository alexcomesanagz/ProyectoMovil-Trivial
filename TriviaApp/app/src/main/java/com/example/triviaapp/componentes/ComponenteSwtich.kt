package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Componente con dos estados
 * cuando lo pulsas cambia de estado
 * @param isChecked estado del componente,
 * siendo este false por defecto
 */
@Composable
fun ComponenteSwitch(){
    var isChecked by remember { mutableStateOf(false) }
    Switch(
        checked = isChecked,
        onCheckedChange = { isChecked = it},
        modifier = Modifier.fillMaxWidth(),
        colors = SwitchDefaults.colors(checkedTrackColor = MaterialTheme.colorScheme.secondary)
    )
}

@Preview
@Composable
fun PrevComponenteSwitch(){
    ComponenteSwitch()
}