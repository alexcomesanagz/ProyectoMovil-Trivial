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
    fun quitaTodo(){
        _uiState.value = _uiState.value.copy(scaffold = false, botonFlotante =false )
    }

    fun ponTodo(){
        _uiState.value = _uiState.value.copy(scaffold = true, botonFlotante =true )
    }

    fun quitaBoton(){
        _uiState.value = _uiState.value.copy(botonFlotante =false )
    }

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






