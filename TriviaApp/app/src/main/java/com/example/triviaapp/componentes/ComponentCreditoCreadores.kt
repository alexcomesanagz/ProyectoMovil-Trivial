package com.example.triviaapp.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComponenteCreditoCreadores(correo: String="",creadorSi: Boolean=false){
    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)
        .padding(horizontal = 10.dp, vertical = 10.dp)) {
        if (creadorSi)

            Text(
                text = "Créditos \n" +
                        "\n" +
                        "Creado por:\n" +
                        correo + "\n" +
                        "\n" +
                        "Programado por:\n" +
                        " Borja Pazo y Alex Comesaña\n",
                )
        else {
            Text(
                text = "Créditos \n" +
                        "\n" +
                        "Programado por:\n" +
                        "Borja Pazo y Alex Comesaña\n"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreditoCreador(){
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        ComponenteCreditoCreadores()

    }
}