package com.example.triviaapp

import android.R.id.primary
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import com.example.compose.TriviaAppTheme
import com.example.compose.primaryDark
import com.example.compose.secondaryDark
import com.example.triviaapp.componentes.Boton
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas




private val botonesRespuestas: List<Boton> = listOf(
    Boton("Respuesta1", modifier = Modifier, color = coloresBoton)
)

class PageItemDetalle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TriviaAppTheme {

            }
        }
    }
}