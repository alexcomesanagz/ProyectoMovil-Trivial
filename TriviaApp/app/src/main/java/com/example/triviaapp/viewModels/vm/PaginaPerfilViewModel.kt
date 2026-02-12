package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.PreferencesLogueadoRepo
import com.example.triviaapp.data.repositorio.TriviasRepoGeneral
import com.example.triviaapp.data.repositorio.UsuarioRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaPerfilUi
import com.example.triviaapp.viewModels.Uis.TajetaUiDatos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPerfilViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PaginaPerfilUi())
    val uiState: StateFlow<PaginaPerfilUi> = _uiState.asStateFlow()
    val preferencias = PreferencesLogueadoRepo.repo
    val usuariorepo = UsuarioRepoGeneral.repo

    val trivialsRepo = TriviasRepoGeneral.repo


    fun cargaDatos() {
        _uiState.value = _uiState.value.copy(
            nombreUsuario = usuariorepo.obtenerNombreUsuario(
                preferencias.getUsuario(),
                onSuccess = {},
                onError = {}),
            correoUsuario = usuariorepo.obtenerCorreoUsuario(
                preferencias.getUsuario(),
                onSuccess = {},
                onError = {}),
            tarjetasUsuario = trivialsRepo.obtenerTrivialsPersona(preferencias.getUsuario(), {}, {})
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