package com.example.triviaapp.viewModels.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.modelo.TrivialDTO
import com.example.triviaapp.viewModels.Uis.PaginaListaUiState
import com.example.triviaapp.viewModels.Uis.TarjetaUiDatos

class PaginaListaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaListaUiState())
    val uiState: StateFlow<PaginaListaUiState> = _uiState.asStateFlow()
    val trivialsRepo = TriviasRepoGeneral.repo

    fun cargar(accion: (String)->Unit) {
        trivialsRepo.leerTodo(
        {it->
             _uiState.value = uiState.value.copy(mapaDatos = it.map {tarjeta->
                TarjetaUiDatos(
                    id = tarjeta.id,
                    titulo = tarjeta.nombre,
                    imagen = tarjeta.categoria
                )
            }, tarjetas =  it.groupBy { dto -> dto.categoria }
                 .mapValues { (_, lista) ->
                     lista.map { dto ->
                         Tarjeta(
                             imagen = dto.categoria,
                             titulo = dto.nombre,
                             accion = {accion(dto.id)}
                         )
                     }
                 })
                },
                {})

        }
    }

