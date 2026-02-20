package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.viewModels.Uis.PaginaPerfilUi
import com.example.triviaapp.viewModels.Uis.TarjetaUiDatos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPerfilViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(PaginaPerfilUi())
    val uiState: StateFlow<PaginaPerfilUi> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)
    val trivialsRepo = TriviasRepoGeneral.repo



    fun cargaDatos() {
        val usuario= usuarioActual.getUsuario()
        if (usuario!=null) {
                _uiState.value = _uiState.value.copy(
                    nombreUsuario = usuario.nombre,
                    correoUsuario = usuario.correo,
                    tarjetasUsuario = obtenListaTrivias(),
                    imagenPerfil= "Perfil"

                )
        }
    }

    fun obtenListaTrivias(): List<TarjetaUiDatos>{
        var lista=listOf<TarjetaUiDatos>()
        trivialsRepo.obtenerTrivialsPersona(
            usuarioActual.getUsuario()!!.id,
            {it-> lista=it.map {
                TarjetaUiDatos(
                    id = it.id,
                    titulo = it.nombre,
                    imagen =it.categoria
                )
              }
            },
            {})
        return lista
    }

}