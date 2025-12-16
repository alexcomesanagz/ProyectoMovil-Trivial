package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviaapp.R

/**
 * Crea un cuadro de texto con el nombre de los programadores y,
 * si lo desea, el autor del trivia
 * @param correo correo del autor del trivia
 * @param creadorSi si se quiere o no que aparezcael creador del trivia
 */
@Composable
fun ComponenteCreditoCreadores(
    correo: String = "",
    creadorSi: Boolean = false
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 30.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxWidth()
    ) {
        if (creadorSi)

            Text(
                text = stringResource(R.string.app_creadores_creditos) +
                        "\n" +
                        stringResource(R.string.app_creadores_usuario) +
                        "\n"+
                        correo  +
                        "\n" +
                        stringResource(R.string.app_programadoPor)+
                        "\n"+
                        stringResource(R.string.app_creadores),
                fontSize = 30.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                color = MaterialTheme.colorScheme.onSecondary
            )
        else {
            Text(
                text = stringResource(R.string.app_creadores_creditos) +
                        "\n" +
                        stringResource(R.string.app_programadoPor)+
                        "\n"+
                        stringResource(R.string.app_creadores), fontSize = 25.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCreditoCreador() {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        ComponenteCreditoCreadores("a",true)

    }
}