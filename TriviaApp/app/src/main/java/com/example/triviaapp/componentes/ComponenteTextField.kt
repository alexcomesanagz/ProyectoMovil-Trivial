package com.example.triviaapp.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


/**
 * Componente para introducir textos
 * @param txtContenido texto que aparece antes de introducir un texto
 * @param txtNuevo texto introducido empleado para actualizar
 */
class DatosTextField(
    val msjPregunta:String="Introduca aquí nombre del Trivial a crear",
    var txtContenido : String="",
    val modif: Modifier= Modifier.fillMaxWidth(),
    var listaColor: List<Color> = listOf(),
    val accion: (String) -> String={""}

)

class DatosTextFieldLista(
    val msjPregunta:String="Introduca aquí nombre del Trivial a crear",
    var txtContenido : String="",
    val i: Int,
    val modif: Modifier= Modifier.fillMaxWidth(),
    var listaColor: List<Color> = listOf(),
    val accion: (Int ,String) -> String={i, it->""}

)
@Composable
fun ComponenteTextField(datos: DatosTextField){
    datos.listaColor=listOf(
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.onSecondary,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onPrimary)

    TextField(
        colors = TextFieldDefaults.colors(
            focusedContainerColor = datos.listaColor.get(0),
            unfocusedContainerColor = datos.listaColor.get(0),
            focusedIndicatorColor = datos.listaColor.get(2),
            cursorColor = datos.listaColor.get(3),
            focusedTextColor = datos.listaColor.get(1),
            unfocusedTextColor = datos.listaColor.get(1)
        ),
        modifier = datos.modif,
        value = datos.txtContenido,
        onValueChange = {txtNuevo -> datos.txtContenido=datos.accion(txtNuevo)},
        label = { Text(datos.msjPregunta, color = datos.listaColor.get(1)) },

    )
}


@Composable
fun ComponenteTextFieldLista(datos: DatosTextFieldLista){
    datos.listaColor=listOf(
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.onSecondary,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.onPrimary)

    TextField(
        colors = TextFieldDefaults.colors(
            focusedContainerColor = datos.listaColor.get(0),
            unfocusedContainerColor = datos.listaColor.get(0),
            focusedIndicatorColor = datos.listaColor.get(2),
            cursorColor = datos.listaColor.get(3),
            focusedTextColor = datos.listaColor.get(1),
            unfocusedTextColor = datos.listaColor.get(1)
        ),
        modifier = datos.modif,
        value = datos.txtContenido,
        onValueChange = { txtNuevo ->
            datos.txtContenido=datos.accion(datos.i,txtNuevo)
        },
        label = { Text(datos.msjPregunta, color = datos.listaColor.get(1)) },

        )
}

@Preview
@Composable
fun PrevComponenteTextField(){
    val mu: MutableState<String> = remember { mutableStateOf(value = "as")}
    //ComponenteTextField(DatosTextField(txtContenido = mu))
}