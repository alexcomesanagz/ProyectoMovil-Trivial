package com.example.triviaapp.viewModels.vm

import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import com.example.triviaapp.componentes.Tarjeta
import com.example.triviaapp.data.repositorio.LogueadoRepo
import com.example.triviaapp.data.repositorio.UsuarioRepo
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import com.example.triviaapp.viewModels.Uis.PaginaFinUiState
import com.example.triviaapp.viewModels.Uis.PaginaPerfilUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaPerfilViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(PaginaPerfilUi())
    val uiState: StateFlow<PaginaPerfilUi> = _uiState.asStateFlow()
    val repoUsuarios = LogueadoRepo()


    fun cargaDatos() {
        _uiState.value = _uiState.value.copy(
            nombreUsuario = repoUsuarios.getUsuario().nombre,
            correoUsuario = repoUsuarios.getUsuario().correo,
            imagenPerfil = repoUsuarios.getUsuario().imagen
        )
    }

}