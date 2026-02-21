package com.example.triviaapp.vista.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.AceptarBoton
import com.example.triviaapp.componentes.ComponenteTextField
import com.example.triviaapp.componentes.DatosTextField
import com.example.triviaapp.componentes.DenegarBoton
import com.example.triviaapp.viewModels.vm.PaginaRegistrarseViewModel

/**
 * Pagina para crear una nueva cuenta
 */
@Composable
fun PaginaSignUp(
    paginaSignUi : PaginaRegistrarseViewModel = viewModel(),
    onItemClick: () -> Unit,
    onSignUpClick:()-> Unit
) {
    val uiState by paginaSignUi.uiState.collectAsState()
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
                        msjPregunta = stringResource(R.string.app_signUp_msjnombre),
                        listaColor = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.onBackground,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.onPrimary),
                        txtContenido = uiState.nombreUsuario,
                        accion = { paginaSignUi.setnombre(it)
                        }
                    )
                )
                ComponenteTextField(
                    DatosTextField(
                        msjPregunta = stringResource(R.string.app_login_msjCorreo),
                        listaColor = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.onBackground,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.onPrimary),
                        txtContenido = uiState.stringCorreo,
                        accion = { paginaSignUi.setCorreo(it)
                        }
                    )
                )
                ComponenteTextField(
                    DatosTextField(
                        msjPregunta = stringResource(R.string.app_login_msjContraseña),
                        listaColor = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.onBackground,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.onPrimary),
                        txtContenido = uiState.stringContrasena,
                        accion = {paginaSignUi.setContrasena(it)
                        }
                    )
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(space = 35.dp),
            ) {
                AceptarBoton(msj = stringResource(R.string.app_login_btnSignUp),
                    modifier = Modifier.fillMaxWidth(),
                    accion = {
                        paginaSignUi.registrar(
                            onSuccess = onSignUpClick,
                            onError = {}
                        )
                    }
                )
            }
            Column(
            ) {
                DenegarBoton(
                    stringResource(R.string.app_bt_salir),
                    accion = onItemClick
                )
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PrevSignUp() {
        PaginaSignUp(onItemClick = {}, onSignUpClick = {})
}
