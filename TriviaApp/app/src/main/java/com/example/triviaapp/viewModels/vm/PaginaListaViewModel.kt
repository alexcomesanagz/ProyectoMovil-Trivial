package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.data.repositorio.reposLocal.ImagenesRepo
import com.example.triviaapp.data.repositorio.reposLocal.TriviasRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaListaUiState
import com.example.triviaapp.viewModels.Uis.TarjetaUiDatos

class PaginaListaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaListaUiState())
    val uiState: StateFlow<PaginaListaUiState> = _uiState.asStateFlow()
    val trivialsRepo = TriviasRepoGeneral.repo

    val imagenesRepo = ImagenesRepo()

    fun cargar() {
          _uiState.value=uiState.value.copy(mapaDatos = obtenListaTrivias())
    }

    fun obtenListaTrivias(): Map<String ,List<TarjetaUiDatos>>{
        var lista: Map<String,List<TarjetaUiDatos>> = mapOf()
        trivialsRepo.leerTodo(
            {it->lista=it.groupBy{it.categoria}.mapValues {
                mapa->
                    mapa.value.map {
                        var imagenTrivia = R.drawable.trivia
                            imagenesRepo.obtenerImagen(
                                categoria = it.categoria,
                                onSuccess = { imagen->
                                    imagenTrivia = imagen.imagen

                                }
                                ,onError = {}
                            )
                            TarjetaUiDatos(
                                id = it.id,
                                titulo = it.nombre,
                                imagen =imagenTrivia
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

