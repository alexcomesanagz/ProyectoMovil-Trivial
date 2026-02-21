package com.example.triviaapp.data.repositorio.reposRetrofit

import android.util.Log
import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoRespuesta
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitRespuestas
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RespuestaRepoRemoto(private val respuestaRetrofit: InterfazRetrofitRespuestas) :
    IRepoRespuesta {
    override fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        respuestaRetrofit.listarRespuestas()
            .enqueue(object : Callback<List<RespuestaDTO>> {
                override fun onResponse(
                    call: Call<List<RespuestaDTO>>,
                    response: Response<List<RespuestaDTO>>
                ) {
                    if (response.isSuccessful) {
                        val lista = response.body()!!.filter { it.idTrivial == idTrivial && it.idUsuario == idUsuario }
                        if(!lista.isEmpty()){onSuccess(lista)}
                        else {
                            onError()
                        }
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<List<RespuestaDTO>?>, t: Throwable) {
                    onError()
                }

            })
    }


    override fun crearRespuestas(
        idTrivial: String,
        idUsuario: String,
        idPreguntas: List<PreguntaDTO>,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        var creadas = 0
        var errorOcurrido = false

        idPreguntas.map {
            val nuevaRespuesta = RespuestaDTO(
                idUsuario = idUsuario,
                idPregunta = it.id,
                idTrivial =  idTrivial,
                respuesta = "1",
                respuestaCorrecta = it.respuestaCorrecta,
                correcta =  it.respuestaCorrecta=="1"
            )
        respuestaRetrofit.crearRespuesta(nuevaRespuesta)
            .enqueue(object : Callback<RespuestaDTO> {

                override fun onResponse(
                    call: Call<RespuestaDTO>,
                    response: Response<RespuestaDTO>
                ) {
                    if (!response.isSuccessful) {
                        if(!errorOcurrido){
                            errorOcurrido = true
                            onError()
                        }
                        return
                    }
                    creadas++

                    if (creadas == idPreguntas.size && !errorOcurrido){
                        onSuccess()
                    }
                }

                override fun onFailure(call: Call<RespuestaDTO>, t: Throwable) {
                    if(!errorOcurrido){
                        errorOcurrido = true
                        onError()
                    }
                }
            })
        }
        onSuccess()
    }

    override fun cambiaRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        respuestaCorrecta:String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        obtenerRespuestasTrivial(idTrivial,idUsuario, {it->
            val respuestaBuscar=it.find { it.idPregunta==idPregunta }
            Log.i("cambio", respuestaBuscar.toString())
            if(respuestaBuscar!=null){
                respuestaBuscar.respuesta=respuesta
                respuestaBuscar.correcta= respuesta==respuestaCorrecta

                respuestaRetrofit.modificaRespuesta(respuestaBuscar.id, respuestaBuscar)
                    .enqueue(object : Callback<RespuestaDTO> {

                        override fun onResponse(
                            call: Call<RespuestaDTO>,
                            response: Response<RespuestaDTO>
                        ) {
                            if (response.isSuccessful && response.body() != null) {
                                onSuccess()
                            } else {
                                onError()
                            }
                        }

                        override fun onFailure(call: Call<RespuestaDTO>, t: Throwable) {
                            onError()
                        }
                    })
            }
        },{}
        )

    }

    override fun recuento(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (Int) -> Unit,
        onError: () -> Unit
    ) {
        // se obtienen todas las respuestas
        respuestaRetrofit.listarRespuestas().enqueue(object : Callback<List<RespuestaDTO>> {

            override fun onResponse(
                call: Call<List<RespuestaDTO>?>,
                response: Response<List<RespuestaDTO>?>
            ) {
                if (response.isSuccessful) {
                    // se filtran las respuestas correctas del usuario para el trivial
                    val listaCorrectas = response.body()
                        ?.filter { it.idTrivial == idTrivial && it.idUsuario == idUsuario && it.correcta }

                    //se devuelve el conteo( 0 en caso de lista nula o vacía)
                    onSuccess(listaCorrectas?.size ?: 0)
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<List<RespuestaDTO>?>, t: Throwable) {
                onError()
            }
        })
    }

    override fun leerTodo(
        onSuccess: (List<RespuestaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        respuestaRetrofit.listarRespuestas().enqueue(object : Callback<List<RespuestaDTO>> {
            override fun onResponse(
                call: Call<List<RespuestaDTO>?>,
                response: Response<List<RespuestaDTO>?>
            ) {
                if (response.isSuccessful) {
                    //se devuelve la lista completa o la lista vacía si body == null
                    onSuccess(response.body() ?: emptyList())
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<List<RespuestaDTO>?>, t: Throwable) {
                onError()
            }
        })
    }
}