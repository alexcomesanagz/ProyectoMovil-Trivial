package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaListaUiState
import com.example.triviaapp.viewModels.Uis.TarjetaUiDatos

class PaginaListaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaListaUiState())
    val uiState: StateFlow<PaginaListaUiState> = _uiState.asStateFlow()
    val trivialsRepo = TriviasRepoGeneral.repo

    fun cargar() {
          _uiState.value=uiState.value.copy(mapaDatos = obtenListaTrivias())
    }

    fun obtenListaTrivias(): Map<String ,List<TarjetaUiDatos>>{
        var lista: Map<String,List<TarjetaUiDatos>> = mapOf()
        trivialsRepo.leerTodo(
            {it->lista=it.groupBy{it.categoria}.mapValues {
                mapa->
                    mapa.value.map {

                            TarjetaUiDatos(
                                id = it.id,
                                titulo = it.nombre,
                                imagen =it.categoria
                            )
                    }
                }
            },
            {})
        return lista
    }
    fun transformaLista(accion: (String)->Unit): Map<String, List<Tarjeta>> {
        val mapaTarjetas: Map<String, List<Tarjeta>> =
            _uiState.value.mapaDatos.mapValues { (_, listaTagetas) ->
                listaTagetas.map { targeta ->
                    Tarjeta(
                        imagen = targeta.imagen,
                        titulo = targeta.titulo,
                        accion = {accion(targeta.id)},
                    )
                }
            }
        return mapaTarjetas
    }

}

