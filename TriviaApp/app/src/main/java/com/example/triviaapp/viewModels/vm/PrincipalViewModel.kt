package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.data.repositorio.ImagenesRepo
import com.example.triviaapp.data.repositorio.InicioRepoGeneral
import com.example.triviaapp.data.repositorio.PreferencesRepo
import com.example.triviaapp.data.repositorio.TriviasRepoGeneral
import com.example.triviaapp.modelo.TrivialDTO
import com.example.triviaapp.viewModels.Uis.PrincipalUiState
import com.example.triviaapp.viewModels.Uis.TarjetaUiDatos

class PrincipalViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(PrincipalUiState())
    val uiState: StateFlow<PrincipalUiState> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)
    val repoInicial= InicioRepoGeneral.repo
    val imagenesRepo = ImagenesRepo()

    val trivialsRepo = TriviasRepoGeneral.repo

    fun cargaDatos() {
        val usuario= usuarioActual.getUsuario()
        if (usuario!=null) {

           var recomendados= listOf<TarjetaUiDatos>()
            var recientes = listOf<TarjetaUiDatos>()
               repoInicial.obtenerRecomendadosPersona(onSuccess = {it->
                   recomendados = it.map {
                       var imagenTrivia=R.drawable.trivia
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
               },
               onError = {})
            repoInicial.obtenerRecientesPersona(usuarioActual.getUsuario()!!.id,
                onSuccess = {it->
                    recientes = it.map {
                        var trivia= TrivialDTO("","","","")
                        trivialsRepo.obtenerTrivial(it.trivia,
                            {triviaCons-> trivia=triviaCons},
                            {}
                        )
                        var imagenTrivia=R.drawable.trivia
                        imagenesRepo.obtenerImagen(
                            categoria = trivia.categoria,
                            onSuccess = { imagen->
                                imagenTrivia = imagen.imagen

                            }
                            ,onError = {}
                        )
                        TarjetaUiDatos(
                            id = trivia.id,
                            titulo =trivia.nombre,
                            imagen =imagenTrivia
                        )
                    }
                },
                onError = {})
            _uiState.value = _uiState.value.copy(
                tarjetasLista1 = recomendados,
                tarjetasLista2 = recientes

            )
        }
    }
}

