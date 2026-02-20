package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.data.repositorio.interfacesRepo.InicioRepoInterface
import com.example.triviaapp.modelo.InicioDTO


class InicioRepo : InicioRepoInterface {
    private val recientes = arrayListOf<InicioDTO>(
    )

    override fun anadirRecientes(
        reciente: InicioDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        if(recientes.find { it.idUsuario==reciente.idUsuario && it.trivia==reciente.trivia }==null) {
            recientes.add(
                InicioDTO(
                    idUsuario = reciente.idUsuario,
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
        var Trivials = recientes.filter { it.idUsuario == idCreador }
        if (Trivials.isEmpty()) {
            onError(Trivials)
        }
        onSuccess(Trivials)
    }

}