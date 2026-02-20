package com.example.triviaapp.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.triviaapp.data.repositorio.objetosRepo.PreguntasRepoGeneral
import com.example.triviaapp.data.repositorio.objetosRepo.RespuestasRepoGeneral
import com.example.triviaapp.data.repositorio.reposLocal.PreferencesRepo
import com.example.triviaapp.viewModels.Uis.PaginaFinUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaFinViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(PaginaFinUiState())
    val uiState: StateFlow<PaginaFinUiState> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val preguntasRepo = PreguntasRepoGeneral.repo



    val usuarioActual = PreferencesRepo(context!!)

    val repuestasRepo = RespuestasRepoGeneral.repo

    fun cargar(idTrivia: String) {
        preguntasRepo.obtenerPreguntasTrivial(
            idTrivial = idTrivia,
            onSuccess = { preguntas ->
                repuestasRepo.recuento(
                    idTrivia,
                    usuarioActual.getUsuario()!!.id,
                    onSuccess = {
                        _uiState.value = _uiState.value.copy(
                            preguntasAcertadas = it,
                            preguntasTotales = preguntas.size
                        )
                    },
                    onError = {})
            },
            onError = {})
    }

    fun cambioImagen() {
        var imagen = ""

            if (_uiState.value.preguntasAcertadas < _uiState.value.preguntasTotales / 2)
                  imagen="Mal"
            else  imagen="Bien"


        _uiState.value =_uiState.value.copy(imagenResultado = imagen)
    }

}
