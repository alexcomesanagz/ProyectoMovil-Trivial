package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.InicioDTO
import com.example.triviaapp.modelo.TrivialDTO

object InicioRepoGeneral {
    val repo = InicioRepo()
}

class InicioRepo : InicioRepoInterface {
    private val recomendados = arrayListOf(
        TrivialDTO(id = "1", idCreador = "1", nombre = "wana", categoria = "Terror"),
        TrivialDTO(id = "2", idCreador = "1", nombre = "nana", categoria = "Accion"),
    )
    private val recientes = arrayListOf<InicioDTO>(
    )


    override fun obtenerRecomendadosPersona(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    ) {
        onSuccess(recomendados)
    }

    override fun anadirRecientes(
        reciente: InicioDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        if(recientes.find { it.idUsiario==reciente.idUsiario && it.trivia==reciente.trivia }==null) {
            recientes.add(
                InicioDTO(
                    idUsiario = reciente.idUsiario,
                    trivia = reciente.trivia
                )
            )
            onSuccess()
        }
    }

    override fun obtenerRecientesPersona(
        idCreador: String,
        onSuccess: (List<InicioDTO>) -> Unit,
        onError: (List<InicioDTO>) -> Unit
    ){
        var Trivials = recientes.filter { it.idUsiario == idCreador }
        if (Trivials.isEmpty()) {
            onError(Trivials)
        }
        onSuccess(Trivials)
    }

}