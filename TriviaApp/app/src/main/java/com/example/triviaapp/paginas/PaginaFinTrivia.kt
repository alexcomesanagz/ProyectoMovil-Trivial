package com.example.triviaapp.paginas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.componentes.ComponenteCreditoCreadores
import com.example.triviaapp.componentes.ComponenteTitulo
import com.example.triviaapp.componentes.DenegartBoton

@Composable
fun PaginaFinTrivia(preguntasAcertadas:Int=0,preguntasTotales:Int=10,) {
    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(space = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Column(verticalArrangement = Arrangement.spacedBy(space = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
        ComponenteTitulo("Preguntas acertadas", 30)
        ComponenteTitulo(""+preguntasAcertadas+"/"+preguntasTotales, 30)
        }
        
        ComponenteCreditoCreadores()
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(weight = 0.5f).fillMaxWidth()) {
                Text(text = "")
            }
            Box(modifier = Modifier.weight(weight = 1f).fillMaxWidth()) {
                DenegartBoton("salir",modifier = Modifier.fillMaxWidth())
            }

            Box(modifier = Modifier.weight(weight = 0.5f).fillMaxWidth()) {
                Text(text = "")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFinTrivia(){
    PaginaFinTrivia()
}