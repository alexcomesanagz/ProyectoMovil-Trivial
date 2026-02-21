package com.example.triviaapp.data.repositorio.reposRetrofit

import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoRespuesta
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitRespuestas
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.RespuestaDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RespuestaRepoRemoto(private val respuestaRetrofit: InterfazRetrofitRespuestas) :
    IRepoRespuesta {
    override fun obtenerRespuestasTrivial(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        respuestaRetrofit.listarRespuestas()
            .enqueue(object : Callback<List<RespuestaDTO>> {
                override fun onResponse(
                    call: Call<List<RespuestaDTO>>,
                    response: Response<List<RespuestaDTO>>
                ) {
                    if (response.isSuccessful) {
                        //Filtramos por trivial y usuario
                        val lista = response.body()
                            ?.filter { it.idTrivial == idTrivial && it.idUsuario == idUsuario }

                        //se devuelve lista no nula aunque esté vacía
                        onSuccess(lista ?: emptyList())
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<List<RespuestaDTO>?>, t: Throwable) {
                    onError()
                }

            })
    }

    override fun obtenerRespuestasCorrectas(
        idTrivial: String,
        idUsuario: String,
        onSuccess: (List<RespuestaDTO?>) -> Unit,
        onError: () -> Unit
    ) {
        respuestaRetrofit.listarRespuestas().enqueue(object : Callback<List<RespuestaDTO>> {

            override fun onResponse(
                call: Call<List<RespuestaDTO>>,
                response: Response<List<RespuestaDTO>>
            ) {
                if (response.isSuccessful) {
                    val listaCorrectas = response.body()
                        ?.filter {
                            it.idTrivial == idTrivial &&
                                    it.idUsuario == idUsuario &&
                                    it.correcta
                        }

                    // se devuelve lista no nula aunque esté vacía
                    onSuccess(listaCorrectas ?: emptyList())
                } else {
                    onError()
                }
            }

            override fun onFailure(call: Call<List<RespuestaDTO>>, t: Throwable) {
                onError()
            }
        })
    }

    override fun crearRespuesta(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val nuevaRespuesta = RespuestaDTO(
            id = "",
            idUsuario = idUsuario,
            idPregunta = idPregunta,
            idTrivial = idTrivial,
            respuesta = "",
            correcta = false
        )

        respuestaRetrofit.crearRespuesta(nuevaRespuesta)
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

    override fun cambiaRespuesta(
        id: String,
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        respuesta: String,
        esCorrecto: Boolean,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        val respuestaActualizada = RespuestaDTO(
            id = id,
            idUsuario = idUsuario,
            idPregunta = idPregunta,
            idTrivial = idTrivial,
            respuesta = respuesta,
            correcta = esCorrecto
        )

        respuestaRetrofit.modificaRespuesta(id, respuestaActualizada)
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

    override fun obtenerRespuestaSeleccionada(
        idTrivial: String,
        idUsuario: String,
        idPregunta: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ): String {
        TODO("Not yet implemented")
    }

//    override fun obtenerRespuestaSeleccionada(
//        idTrivial: String,
//        idUsuario: String,
//        idPregunta: String,
//        onSuccess: () -> Unit,
//        onError: () -> Unit
//    ): String {
//        // Obtenemos todas las respuestas
//        respuestaRetrofit.listarRespuestas().enqueue(object : Callback<List<RespuestaDTO>> {
//
//            override fun onResponse(
//                call: Call<List<RespuestaDTO>>,
//                response: Response<List<RespuestaDTO>>
//            ) {
//                if (response.isSuccessful) {
//                    val seleccionada = response.body()
//                        ?.firstOrNull { it.idTrivial == idTrivial && it.idUsuario == idUsuario && it.idPregunta == idPregunta }
//                        ?.respuesta
//
//                    if (seleccionada != null) {
//                        onSuccess(seleccionada)
//                    } else {
//                        onError()
//                    }
//                } else {
//                    onError()
//                }
//            }
//
//            override fun onFailure(call: Call<List<RespuestaDTO>>, t: Throwable) {
//                onError()
//            }
//        })
//    }



}