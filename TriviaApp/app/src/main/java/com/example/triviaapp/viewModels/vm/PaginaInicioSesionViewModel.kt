package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.UsuarioRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.modelo.PreferenceDTO
import com.example.triviaapp.viewModels.Uis.PaginaInicioSesionUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaInicioSesionViewModel(application: Application) : AndroidViewModel(application)  {

    private val _uiState = MutableStateFlow(PaginaInicioSesionUi())
    val uiState: StateFlow<PaginaInicioSesionUi> = _uiState.asStateFlow()
    val repoUsuarios = UsuarioRepoGeneral.repo
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)

    /**
     * cambia el nombre
     */
    fun setNombre(correo: String): String {
        _uiState.value = _uiState.value.copy(stringNombre = correo)
        return _uiState.value.stringNombre
    }

    /**
     * cambia la contraseña
     */
    fun setContrasena(contrasena: String): String {
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }

    /**
     * loguea al usuario si el nombre existía y la contraseña es correcta
     */
    fun logIn(onSucces: () -> Unit,onError: ()->Unit) {
        repoUsuarios.iniciarSesion(
            nombre = uiState.value.stringNombre,
            contasena = uiState.value.stringContrasena,
            onSuccess = { it->
                usuarioActual.registraUsuario(
                    usuario = PreferenceDTO(
                        id = it?.id ?: "",
                        nombre = it?.nombre ?: "",
                        correo = it?.correo ?: ""
                    ),
                    onSuccess = {onSucces()},
                    onError = onError
                )

            },
            onError = onError)

    }

    /**
     * permite que la contraseña esté oculta o no
     */
    fun setVisibilidad() {
        _uiState.value = _uiState.value.copy(contrasenaVisible = !uiState.value.contrasenaVisible)
    }





}