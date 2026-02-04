package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviaapp.R

/**
 * Componente con los ajustes para crear un trivia
 * @param txtBotones lista de textos con tipos de categoría
 * @param tamañoTexto tamaño de la letra de los botones
 */
@Composable
fun ComponenteCajaDatosTrivia(
    radioButonSeleccionado: String,
    accionRadioButons: (String) -> String = { "" },
    cadenaField: String,
    accionTextField: (String) -> String = { "" },
    estadoSlider: Float,
    accionSlider: (Float) -> Float = { 1f }

) {
    val txtBotones: List<String> = listOf(
        stringResource(R.string.app_categoria1),
        stringResource(R.string.app_categoria2),
        stringResource(R.string.app_categoria3),
        stringResource(R.string.app_categoria4)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ComponentePreguntaYRespuestas(
                DatosRespondePregunta(
                    stringResource(R.string.app_titulo_categorias),
                    txtBotones,
                    1,
                    radioButonSeleccionado,
                    accionRespuestas = accionRadioButons
                )
            )
            Column() {
                ComponenteTituloCaja(stringResource(R.string.app_titulo_nombreTrivia))
                ComponenteTextField(
                    DatosTextField(
                        txtContenido = cadenaField,
                        listaColor = listOf(
                            MaterialTheme.colorScheme.secondary,
                            MaterialTheme.colorScheme.onSecondary,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.onPrimary),
                        accion = accionTextField
                    )
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        RoundedCornerShape(12.dp)
                    )
                    .padding(bottom = 10.dp)
            ) {
                ComponenteTituloCaja(stringResource(R.string.app_titulo_tituloSlider))
                ComponenteSlider(DatosSlider(estadoSlider, accionSlider))
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevComponenteCajaDatosTrivia() {
    ComponenteCajaDatosTrivia(
        "",
        cadenaField = "",
        estadoSlider = 0f
    )
}