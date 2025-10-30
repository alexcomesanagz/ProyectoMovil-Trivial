package com.example.triviaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.componentes.ComponenteListaTarjetas
import com.example.triviaapp.componentes.ComponenteTarjetaHorizontal
import com.example.triviaapp.componentes.ComponenteTituloYListaTarjetas
import com.example.triviaapp.componentes.Tarjeta

private val titulo: String = "Título de prueba"
private val tarjetas: List<Tarjeta> = listOf(
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela"),
    Tarjeta(R.drawable.ic_launcher_background,"Abuela")
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TriviaAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ComponenteTituloYListaTarjetas(titulo, tarjetas)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TriviaAppTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun prevComponenteTituloYlistaTarjetas(){
    TriviaAppTheme {
        ComponenteTituloYListaTarjetas(titulo, tarjetas)
    }
}
