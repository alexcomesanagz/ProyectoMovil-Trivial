package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.viewModels.Uis.PaginaListaUiState

class PaginaListaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaListaUiState())
    val uiState: StateFlow<PaginaListaUiState> = _uiState.asStateFlow()

    fun transformaLista(accion: (String)->Unit): Map<String, List<Tarjeta>> {
        val mapaTarjetas: Map<String, List<Tarjeta>> =
            _uiState.value.mapaDatos.mapValues { (_, listaTagetas) ->
                listaTagetas.map { targeta ->
                    Tarjeta(
                        imagen = targeta.imagen,
                        titulo = targeta.titulo,
                        accion = accion,
                        id = targeta.id
                    )
                }
            }
        return mapaTarjetas
    }

}

