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
        TrivialDTO(id = "1", idCreador ="1", nombre = "wana",categoria = "Terror"),
        TrivialDTO(id = "2", idCreador ="1", nombre = "nana",categoria = "Accion"),
    )
     override fun obtenerTrivialsPersona(idCreador: String, onSuccess: (List<TrivialDTO>) -> Unit, onError: (List<TrivialDTO>) -> Unit){
        var Trivials = datos.filter { it.idCreador == idCreador }
        if (Trivials.isEmpty()) {
            onError(Trivials)
        }
         onSuccess(Trivials)
     }

    override fun registrar(idCreador: String, nombre: String, categoria: String, onSuccess: (TrivialDTO) -> Unit, onError: () -> Unit) {
            datos.add(
                TrivialDTO(
                    id = "${datos.size+1}",
                    idCreador = idCreador,
                    nombre = nombre,
                    categoria = categoria
                )
            )
            onSuccess(datos.find { it.id=="${datos.size}"}!!)
    }

    override fun borrar(idTrivia: String, onSuccess: () -> Unit, onError: () -> Unit) {
        val trivia=datos.find { it.id==idTrivia }
        if(trivia!=null){
        datos.remove(trivia)
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