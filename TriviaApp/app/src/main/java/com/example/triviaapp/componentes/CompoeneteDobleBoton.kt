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


@Composable
fun BotonesAceptarDenegarLinea(msjBot1: String, msjBot2: String) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(30.dp),
    ) {

        Box(modifier = Modifier.weight(1f)) {
            DenegartBoton(
                msj = msjBot1,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            AceptartBoton(
                msj = msjBot2,
                modifier = Modifier.fillMaxWidth()

            )
        }
    }
}

@Composable
fun BotonesDobleAceptarLinea(msjBot1: String, msjBot2: String) {
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
                msjBot1, Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            )
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            AceptartBoton(
                msjBot2, Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun BotonesDobleAceptarColumna(msjBot1: String, msjBot2: String) {
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        AceptartBoton(msjBot1)
        AceptartBoton(msjBot2)
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDobleBoton() {
    Column {
        BotonesAceptarDenegarLinea("no", "si")
        BotonesDobleAceptarLinea("si", "si")
        BotonesDobleAceptarColumna("si", "si")
    }
}
