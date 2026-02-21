package com.example.triviaapp.viewModels.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.PreguntasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.TriviasRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
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

    val preguntasRepo = PreguntasRepoGeneral.repo

    fun crearTrivia(onSucces: (String)->Unit, onError:()-> Unit) {
        if(uiState.value.categoria!="" && uiState.value.nombreTriv!="" && uiState.value.preguntas>0){
            trivialsRepo.crearTrivia(
                idCreador = usuarioActual.getUsuario()!!.id,
                nombre = uiState.value.nombreTriv,
                categoria = uiState.value.categoria,
                onSuccess = {trivia->
                    preguntasRepo.crearPreguntas(trivia.id,
                        numPreg=uiState.value.preguntas,
                        onSuccess={onSucces(trivia.id)},
                    onError={}
                    )
                },
                onError = onError
            )
        }
    }

    /**
     * cambia la categoria del trivia a crear
     */
    fun setCategoria(categoria: String): String{
        _uiState.value = _uiState.value.copy(categoria = categoria)
        return categoria
    }

    /**
     * cambia el nombre del trivia a crear
     */
    fun setNombreTrivia(nombre: String): String{
        _uiState.value = _uiState.value.copy(nombreTriv = nombre)
        return nombre
    }

    /**
     * cambia la cantidad de preguntas del trivia a crear
     */
    fun setPreguntas(numPreguntas: Float): Float{
        _uiState.value = _uiState.value.copy(preguntas = numPreguntas.toInt())
        return _uiState.value.preguntas.toFloat()
    }

}






