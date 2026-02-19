package com.example.triviaapp.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.ImagenesRepo
import com.example.triviaapp.data.repositorio.PreferencesRepo
import com.example.triviaapp.data.repositorio.PreguntasRepoGeneral
import com.example.triviaapp.data.repositorio.RespuestasRepoGeneral
import com.example.triviaapp.viewModels.Uis.PaginaFinUiState
import com.example.triviaapp.viewModels.Uis.Pregunta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaginaFinViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(PaginaFinUiState())
    val uiState: StateFlow<PaginaFinUiState> = _uiState.asStateFlow()
    private val context: Context?
        get() = getApplication<Application>().applicationContext
    val preguntasRepo = PreguntasRepoGeneral.repo

    val imagenesRepo = ImagenesRepo()


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
        var imagen = 0

            if (_uiState.value.preguntasAcertadas < _uiState.value.preguntasTotales / 2) {
                imagenesRepo.obtenerImagen("Mal",
                    { it -> imagen = it.imagen },
                    {}
                )
            } else {
                imagenesRepo.obtenerImagen("Bien",
                    { it -> imagen = it.imagen },
                    {}
                )
            }
        _uiState.value =_uiState.value.copy(imagenResultado = imagen)
    }

}
