package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecomendadosComponente(enunciado: String, modifier: Modifier, ) {

    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
        ){
        Text(
            text = enunciado,
            modifier = Modifier
                .size(40.dp)
        )
        Column {
            Text("1")
            Text("2")
            Text("3")
        }
    }

}

@Preview
@Composable
fun prevRecomendadosComponente() {
    RecomendadosComponente("Recientes", Modifier);
}