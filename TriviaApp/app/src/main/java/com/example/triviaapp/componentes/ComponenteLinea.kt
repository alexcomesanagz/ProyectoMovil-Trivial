package com.example.triviaapp.componentes

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Componente que hace una linea horizontal
 * @param modifier modificaciones línea
 * @param grosor grosor de línea
 * @param color color línea
 */
@Composable
fun ComponenteLinea(
    modifier: Modifier = Modifier.fillMaxWidth(),
    grosor: Dp = 6.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    HorizontalDivider(modifier, grosor, color)
}

@Preview
@Composable
fun PrevComponenteLinea() {
    ComponenteLinea()
}