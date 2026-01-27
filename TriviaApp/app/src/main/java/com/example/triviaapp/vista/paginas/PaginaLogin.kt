package com.example.triviaapp.vista.paginas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TriviaAppTheme
import com.example.triviaapp.R
import com.example.triviaapp.componentes.BotonesDobleAceptarColumna
import com.example.triviaapp.componentes.ComponenteTextField
import com.example.triviaapp.componentes.DatosBotonDoble
import com.example.triviaapp.componentes.DatosTextField
import com.example.triviaapp.componentes.DenegarBoton

/**
 * Pagina para entrar en tu cuenta ya creada o crear una nueva
 */
@Composable
fun PaginaLogin() {
    var nombre = ""
    var pasword = ""

    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 50.dp),
            modifier = Modifier.padding(vertical = 130.dp, horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Column(verticalArrangement = Arrangement.spacedBy(space = 35.dp)) {
                ComponenteTextField(
                    DatosTextField(
                        msjPregunta = stringResource(R.string.app_login_msjCorreo),
                        txtContenido = nombre,
                        accion = { it ->
                            nombre = it
                            return@DatosTextField nombre
                        }
                    )
                )
                ComponenteTextField(
                    DatosTextField(
                        stringResource(R.string.app_login_msjContraseña),
                        txtContenido = pasword,
                        accion = {it-> pasword=it
                            return@DatosTextField pasword }
                    )
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(space = 35.dp),
            ) {
                BotonesDobleAceptarColumna(
                    DatosBotonDoble(
                        msjBot1 = stringResource(R.string.app_login_btnLogIn),
                        msjBot2 = stringResource(R.string.app_login_btnSignUp),
                        modifierBotones = Modifier.fillMaxWidth(),
                        accionBoton1 = { Log.e("Testing", "Aceptar boton cliqueado") },
                        accionBoton2 = { Log.e("Testing", "Aceptar boton cliqueado") })
                )
            }
            Column(
            ) {
                DenegarBoton(stringResource(R.string.app_bt_salir))
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PrevPaginaLogin() {
    TriviaAppTheme {
        PaginaLogin()
    }
}
