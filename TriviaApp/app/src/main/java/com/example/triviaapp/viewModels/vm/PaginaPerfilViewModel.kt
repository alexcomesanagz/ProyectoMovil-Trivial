package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.PreferencesRepo
import com.example.triviaapp.data.repositorio.TriviasRepoGeneral
import com.example.triviaapp.data.repositorio.UsuarioRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaPerfilUi
import com.example.triviaapp.viewModels.Uis.TajetaUiDatos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPerfilViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(PaginaPerfilUi())
    val uiState: StateFlow<PaginaPerfilUi> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val preferencias= PreferencesRepo(context!!)
    val usuariorepo = UsuarioRepoGeneral.repo

    val trivialsRepo = TriviasRepoGeneral.repo


    fun cargaDatos() {
        val usuario= preferencias.getUsuario()
        if (usuario!=null) {
            _uiState.value = _uiState.value.copy(
                nombreUsuario = usuario.nombre,
                correoUsuario = usuario.correo,
                tarjetasUsuario = trivialsRepo.obtenerTrivialsPersona(
                    usuario.id,
                    {},
                    {})
                    .map { it ->
                        TajetaUiDatos(
                            id = it.id,
                            titulo = it.nombre,
                            imagen = R.drawable.trivia
                        )
                    }
            )
        }
    }

}