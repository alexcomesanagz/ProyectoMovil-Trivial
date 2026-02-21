package com.example.triviaapp.data.repositorio.reposRetrofit


import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoPregunta
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitPreguntas
import com.example.triviaapp.modelo.PreguntaDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreguntasRepoRemoto(private val preguntaRetrofit: InterfazRetrofitPreguntas) : IRepoPregunta {
    override fun obtenerPreguntasTrivial(
        idTrivial: String,
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        preguntaRetrofit.listarPreguntas()
            .enqueue(object : Callback<List<PreguntaDTO>> {

                override fun onResponse(
                    call: Call<List<PreguntaDTO>>,
                    response: Response<List<PreguntaDTO>>
                ) {

                    val lista = response.body()!!.filter { it.idTrivial == idTrivial }

                    if (response.isSuccessful && !lista.isEmpty()) {
                        onSuccess(lista)
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<List<PreguntaDTO>>, t: Throwable) {
                    onError()
                }
            })
    }

    override fun obtenerPregunta(
        idPregunta: String,
        idTrivial: String,
        onSuccess: (PreguntaDTO?) -> Unit,
        onError: () -> Unit
    ) {
        preguntaRetrofit.obtenerPregunta(idPregunta)
            .enqueue(object : Callback<PreguntaDTO> {

                override fun onResponse(
                    call: Call<PreguntaDTO>,
                    response: Response<PreguntaDTO>
                ) {
                    val pregunta = response.body()

                    if (response.isSuccessful && pregunta != null) {
                        onSuccess(pregunta)
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<PreguntaDTO>, t: Throwable) {
                    onError()
                }
            })
    }

    override fun crearPreguntas(
        idTrivial: String,
        numPreg: Int,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        var creadas = 0
        var errorOcurrido = false

        repeat(numPreg) {

            val nueva = PreguntaDTO(
                id = "",
                idTrivial = idTrivial,
                opcion1 = "",
                opcion2 = "",
                opcion3 = "",
                opcion4 = "",
                pregunta = "",
                respuestaCorrecta = "1"
            )

            preguntaRetrofit.crearPregunta(nueva)
                .enqueue(object : Callback<PreguntaDTO> {

                    override fun onResponse(
                        call: Call<PreguntaDTO>,
                        response: Response<PreguntaDTO>
                    ) {
                        if (!response.isSuccessful) {
                            if(!errorOcurrido){
                                errorOcurrido = true
                                onError()
                            }
                            return
                        }

                        creadas++

                        if (creadas == numPreg && !errorOcurrido){
                            onSuccess()
                        }
                    }

                    override fun onFailure(call: Call<PreguntaDTO>, t: Throwable) {
                        if(!errorOcurrido){
                            errorOcurrido = true
                            onError()
                        }
                    }
                })
        }
    }

    override fun borrarPreguntas(
        idTrivial: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        obtenerPreguntasTrivial(
            idTrivial,
            onSuccess = { lista ->

                var eliminadas = 0
                lista.forEach { pregunta ->
                    preguntaRetrofit.borrarPregunta(pregunta.id).enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            if (response.isSuccessful) {
                                eliminadas++
                                if (eliminadas == lista.size) onSuccess()
                            } else onError()
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            onError()
                        }
                    })
                }
            },
            onError = { onError() }
        )
    }


    override fun cambiaDatosPregunta(
        pregunta: PreguntaDTO,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        preguntaRetrofit.modificaPregunta(id = pregunta.id,pregunta)
            .enqueue(object : Callback<PreguntaDTO> {

            override fun onResponse(
                call: Call<PreguntaDTO>,
                response: Response<PreguntaDTO>
            ) {
                if (response.isSuccessful ) {
                    onSuccess()
                } else {
                    onError()
                }
            }

            override fun onFailure(
                call: Call<PreguntaDTO>,
                t: Throwable) {
                onError()
            }
        })
    }


    override fun leerTodo(
        onSuccess: (List<PreguntaDTO>) -> Unit,
        onError: () -> Unit
    ) {
        preguntaRetrofit.listarPreguntas().enqueue(object : Callback<List<PreguntaDTO>> {

            override fun onResponse(
                call: Call<List<PreguntaDTO>>,
                response: Response<List<PreguntaDTO>>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body() ?: emptyList())
                } else onError()
            }

            override fun onFailure(call: Call<List<PreguntaDTO>>, t: Throwable) {
                onError()
            }
        })
    }
}
