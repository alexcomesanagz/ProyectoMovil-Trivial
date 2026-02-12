package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.PreferencesRepo
import com.example.triviaapp.data.repositorio.TriviasRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaAjustesUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaAjustesViewModel(application: Application) : AndroidViewModel(application)  {

    private val _uiState = MutableStateFlow(PaginaAjustesUi())
    val uiState: StateFlow<PaginaAjustesUi> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val usuarioActual= PreferencesRepo(context!!)
    val trivialsRepo = TriviasRepoGeneral.repo

    fun crearTrivia(onSucces: (String)->Unit, onError:()-> Unit) {
        if(uiState.value.categoria!="" && uiState.value.nombreTriv!="" && uiState.value.preguntas>0){
            trivialsRepo.registrar(
                idCreador = usuarioActual.getUsuario()!!.id,
                nombre = uiState.value.nombreTriv,
                categoria = uiState.value.categoria,
                onSuccess = {it-> onSucces(it.id)},
                onError = onError
            )
        }
    }
    fun setCategoria(categoria: String): String{
        _uiState.value = _uiState.value.copy(categoria = categoria)
        return categoria
    }

    fun setNombreTrivia(nombre: String): String{
        _uiState.value = _uiState.value.copy(nombreTriv = nombre)
        return nombre
    }

    fun setPreguntas(numPreguntas: Float): Float{
        _uiState.value = _uiState.value.copy(preguntas = numPreguntas.toInt())
        return _uiState.value.preguntas.toFloat()
    }

}






