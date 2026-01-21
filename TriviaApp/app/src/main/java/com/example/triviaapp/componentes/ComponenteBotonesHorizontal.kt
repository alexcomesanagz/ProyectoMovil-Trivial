package com.example.triviaapp.componentes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * crea 4 botones divididos entre 2 filas y 2 columnas
 * @param txtBotones contiene el texto de cada boton, tienen que ser 4
 * @param tamanioTexto tamaño de el texto que contienen los botones
 * @param accionBotones contiene las acciones de cada boton
 */
@Composable
fun ComponenteBotonesHorizontal(
    txtBotones: List<String>,
    accionBotones:List<() -> Unit>,
    tamanioTexto:Int=12
) {

    Row(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            BotonesDobleAceptarLinea(DatosBotonDoble(
                txtBotones.get(0),
                txtBotones.get(1),
                accionBoton1 = accionBotones.get(0),
                accionBoton2 = accionBotones.get(1),
                tamanioTexto = tamanioTexto)
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            BotonesDobleAceptarLinea(DatosBotonDoble(
                txtBotones.get(2),
                txtBotones.get(3),
                accionBoton1 = accionBotones.get(2),
                accionBoton2 = accionBotones.get(3),
                tamanioTexto = tamanioTexto)
            )
        }
    }
}
class DatosRadioBotones( val txtBotones: List<String>,
                         val tamanioTexto:Int=12,
                         var remember: MutableState<String>)
@Composable
fun ComponenteRadioButonsHorizontal(
   datos: DatosRadioBotones
) {
    var listaColor = listOf<Color>(
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.surface,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onPrimary
    )
    var i=1
    var listaPrimerPart: ArrayList<String> = arrayListOf()
    var listaSegundaPart: ArrayList<String> = arrayListOf()
    var x=datos.txtBotones.size
    datos.txtBotones.forEach { it->
        if(i<=x/2) listaPrimerPart.add(it)
        else listaSegundaPart.add(it)
        i++
    }

    Row(
        modifier = Modifier
            .padding(bottom = 10.dp, top = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                .padding(bottom = 10.dp)
            ) {

                listaPrimerPart.forEach { prim->
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        ComponenteRadioButon(
                            DatosRadioBoton(
                                msj = prim,
                                coloresBoton = listaColor,
                                tamanioTexto = datos.tamanioTexto,
                                remember = datos.remember,
                            )
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                .padding(bottom = 10.dp)
            ) {
                listaSegundaPart.forEach { seg->
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        ComponenteRadioButon(
                            DatosRadioBoton(
                                msj = seg,
                                coloresBoton = listaColor,
                                tamanioTexto = datos.tamanioTexto,
                                remember = datos.remember,
                            )
                        )
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun PrevComponenteBotonesHorizontal() {
    val txtBotones: List<String> = listOf(
        "1", "2", "3", "4"
    )
    val accionbotones: List<() -> Unit> = listOf(
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") },
        { Log.e("Testing", "Aceptar boton cliqueado") }
    )

    ComponenteBotonesHorizontal(txtBotones, accionBotones = accionbotones)
}