package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.data.repositorio.interfacesRepo.RecientesRepoInterface
import com.example.triviaapp.modelo.RecientesDTO


class RecientesRepo : RecientesRepoInterface {
    private val recientes = arrayListOf<RecientesDTO>(
    )

    override fun anadirReciente(
        reciente: RecientesDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        if(recientes.find { it.idUsuario==reciente.idUsuario && it.trivia==reciente.trivia }==null) {
            recientes.add(
                RecientesDTO(
                    idUsuario = reciente.idUsuario,
                    trivia = reciente.trivia,
                    nombre = reciente.nombre,
                    categoria = reciente.categoria,

                )
            )
            onSuccess()
        }
    }

    override fun obtenerRecientesPersona(
        idCreador: String,
        onSuccess: (List<RecientesDTO>) -> Unit,
        onError: (List<RecientesDTO>) -> Unit
    ){
        var Trivials = recientes.filter { it.idUsuario == idCreador }
        if (Trivials.isEmpty()) {
            onError(Trivials)
        }
        onSuccess(Trivials)
    }

}