package com.example.triviaapp.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.paginas.tarjetasUsuario
import kotlinx.coroutines.launch

class ElegirRespViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ElegirRespUIState())
    val uiState: StateFlow<ElegirRespUIState> = _uiState.asStateFlow()

    fun getPregunta() : Pregunta{
        return uiState.value.preguntas[uiState.value.i]
    }

    fun getNumPreguntas() : Int{
        return uiState.value.preguntas.size
    }

    fun cambiaRespuestaBoton(cadena :String) :String {
         getPregunta().botonRespuesta.value=cadena
        return getPregunta().botonRespuesta.value
    }

    fun siguientePregunta(){
        if( uiState.value.i < uiState.value.preguntas.size){
            _uiState.value.i.inc()

        }

    }
    fun anteriorPregunta(){
        if( uiState.value.i>0){
            uiState.value.i.dec()
        }
    }

}

data class ElegirRespUIState(
    val preguntas: List<Pregunta> =listOf(
        Pregunta(),
        Pregunta(),
        Pregunta(),
        Pregunta()
    ),
    var i: Int = 0
)

class Pregunta(
    val textoBotonesRespuestas: List<MutableState<String>> = listOf(
        mutableStateOf(""),
        mutableStateOf(""),
        mutableStateOf(""),
        mutableStateOf("")
    ),
    var botonRespuesta: MutableState<String> =mutableStateOf(""),
    val pregunta: MutableState<String> = mutableStateOf("")
)