package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.viewModels.Uis.MainUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(MainUi())
    val uiState: StateFlow<MainUi> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)


    fun cargar(){
        val currentUser = usuarioActual.getUsuario()
        if(currentUser!=null)_uiState.value=_uiState.value.copy(logueado = true)
    }

    /**
     * quita el scafold y el boton flotante de la vista
     */
    fun quitaTodo(){
        _uiState.value = _uiState.value.copy(scaffold = false, botonFlotante =false )
    }

    /**
     * coloca el scafold y el boton flotante
     */
    fun ponTodo(){
        _uiState.value = _uiState.value.copy(scaffold = true, botonFlotante =true )
    }

    /**
     * quita el boton flotante de la vista
     */
    fun quitaBoton(){
        _uiState.value = _uiState.value.copy(botonFlotante =false )
    }

    /**
     * cierra la sesion del usuario actual
     */
    fun salirLogueado(onSuccess:()-> Unit, onError: ()->Unit){
        usuarioActual.cerrarSesion(
            onSuccess = {
                _uiState.value=_uiState.value.copy(logueado = false)
                onSuccess()
                },
        onError = onError
        )
    }


}






