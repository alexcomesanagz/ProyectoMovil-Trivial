package com.example.triviaapp.data.repositorio

import com.example.triviaapp.R
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.TrivialDTO
import com.example.triviaapp.modelo.UsuarioDTO

object TriviasRepoGeneral{
    val repo= TrivialRepo()
}

class TrivialRepo: TrivialRepoInterface{
    private val datos = arrayListOf(
        TrivialDTO(id = "1", idCreador ="1", nombre = "wana",categoria = "miedo"),
        TrivialDTO(id = "2", idCreador ="1", nombre = "nana",categoria = "miedo"),
    )
     override fun obtenerTrivialsPersona(idCreador: String, onSuccess: () -> Unit, onError: () -> Unit): List<TrivialDTO> {
        var Trivials = datos.filter { it.idCreador == idCreador }
        if (Trivials.isEmpty()) {
            onError()
            return listOf<TrivialDTO>()
        }
         onSuccess()
         return Trivials
     }

    override fun registrar(idCreador: String, nombre: String, categoria: String, onSuccess: (TrivialDTO) -> Unit, onError: () -> Unit) {
            datos.add(
                TrivialDTO(
                    id = ""+datos.size,
                    idCreador = idCreador,
                    nombre = nombre,
                    categoria = categoria
                )
            )
            onSuccess(datos.find { it.idCreador==idCreador && it.nombre==nombre && it.categoria==categoria }!!)
    }

    override fun borrar(idTrivia: String, onSuccess: () -> Unit, onError: () -> Unit) {
        if(datos.find { it.id==idTrivia }!=null){
        datos.remove(datos.find { it.id==idTrivia }!!)
        onSuccess()
        }
        else onError()
    }

//    companion object{
//        val preguntas() = ArrayList<PreguntaDTO>(
//            listOf(
//                PreguntaDTO(),
//                PreguntaDTO(),
//                PreguntaDTO(),
//                PreguntaDTO()
//            ))
//            var currId = 1;
//    }

    //crud

}