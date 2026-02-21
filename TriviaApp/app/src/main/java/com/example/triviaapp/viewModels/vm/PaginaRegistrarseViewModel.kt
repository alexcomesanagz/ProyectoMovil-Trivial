package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.UsuarioRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.modelo.PreferenceDTO
import com.example.triviaapp.viewModels.Uis.PaginaRegistrarse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaRegistrarseViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(PaginaRegistrarse())
    val uiState: StateFlow<PaginaRegistrarse> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)
    val repoUsuarios = UsuarioRepoGeneral.repo

    /**
     * cambia el correo
     */
    fun setCorreo(correo: String): String {
        _uiState.value = _uiState.value.copy(stringCorreo = correo)
        return _uiState.value.stringCorreo
    }

    /**
     * cambia el nombre
     */
    fun setnombre(nombre: String): String {
        _uiState.value = _uiState.value.copy(nombreUsuario = nombre)
        return _uiState.value.stringCorreo
    }

    /**
     * cambia la contraseña
     */
    fun setContrasena(contrasena: String): String {
        _uiState.value = _uiState.value.copy(stringContrasena = contrasena)
        return _uiState.value.stringContrasena
    }

    /**
     * se crea el usuario si el nombre no existía ya
     */
    fun registrar(onSuccess:()-> Unit,onError:()-> Unit) {
        repoUsuarios.registrar(
            nombre = uiState.value.nombreUsuario,
            correo = uiState.value.stringCorreo,
            contasena = uiState.value.stringContrasena,
            onSuccess = { it->
                usuarioActual.registraUsuario(
                        usuario = PreferenceDTO(
                            id = it?.id ?: "",
                            nombre = it?.nombre ?: "",
                            correo = it?.correo ?: ""),
                    onSuccess = onSuccess,
                    onError = {}
                    )
                },
                onError = onError)
    }


}