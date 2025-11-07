package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



/**
 * @param msjBot1 mensaje que aparecera dentro del primer boton
 * @param msjBot2 mensaje que aparecera dentro del segundo boton
 * @param modifierBotones modificador que se puede usar para cambiar el modificador de los botones llamados
 * @param accionBoton1 acccion que tomara el primer boton al hacerle click
 * @param accionBoton2 acccion que tomara el primer boton al hacerle click
 */
class DatosBotonDoble(
    var msjBot1: String,
    var msjBot2: String,
    var modifierBotones: Modifier= Modifier,
    var accionBoton1: () -> Unit = {},
    var accionBoton2: () -> Unit = {}
)



/**
 * creación en linea de dos botones, uno para denegar y otro para aceptar,
 * tendrán el mismo tamaño los dos en base al espacio disponible
 */
@Composable
fun BotonesAceptarDenegarLinea(datosBotones: DatosBotonDoble) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(30.dp),
    ) {

        Box(modifier = Modifier.weight(1f)) {

            DenegartBoton(
                msj = datosBotones.msjBot1,
                modifier = Modifier.fillMaxWidth(),
                accion = datosBotones.accionBoton2
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            AceptartBoton(
                msj = datosBotones.msjBot2,
                modifier = Modifier.fillMaxWidth(),
                accion = datosBotones.accionBoton2


            )
        }
    }
}



/**
 * creación en linea de dos botones,
 * tendrán el mismo tamaño los dos en base al espacio disponible
 */
@Composable
fun BotonesDobleAceptarLinea(datosBotones: DatosBotonDoble) {
    Row(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            AceptartBoton(
                datosBotones.msjBot1, Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                accion = datosBotones.accionBoton1
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            AceptartBoton(
                datosBotones.msjBot2, Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                accion = datosBotones.accionBoton2
            )
        }
    }
}



/**
 * creación en columna de dos botones,
 * tendrán el mismo tamaño los dos en base al espacio disponible
 */
@Composable
fun BotonesDobleAceptarColumna(datosBotones: DatosBotonDoble) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 40.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        AceptartBoton(msj = datosBotones.msjBot1,
            modifier = datosBotones.modifierBotones,
            accion = datosBotones.accionBoton1)
        AceptartBoton(msj = datosBotones.msjBot1,
            modifier = datosBotones.modifierBotones,
            accion = datosBotones.accionBoton1)
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDobleBoton() {
    Column {
        var botones= DatosBotonDoble("si","no")
        BotonesAceptarDenegarLinea(botones)
        BotonesDobleAceptarLinea(botones)
        BotonesDobleAceptarColumna(botones)
    }
}
