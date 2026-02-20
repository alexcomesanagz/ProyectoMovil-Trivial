package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.objetosRepo.InicioRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.RecomendadosRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.triviaapp.data.repositorio.reposLocal.ImagenesRepo
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
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

    val recomendadosRepo= RecomendadosRepoGeneral.repo
    fun cargaDatos() {
        val usuario= usuarioActual.getUsuario()
        if (usuario!=null) {

           var recomendados= listOf<TarjetaUiDatos>()
            var recientes = listOf<TarjetaUiDatos>()

               recomendadosRepo.obtenerRecomendadosPersona(onSuccess = {it->
                   recomendados = it.map {
                       var trivia= TrivialDTO("","","","")
                       trivialsRepo.obtenerTrivial(it.idTrivia,
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
                           id = it.idTrivia,
                           titulo = trivia.nombre,
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

