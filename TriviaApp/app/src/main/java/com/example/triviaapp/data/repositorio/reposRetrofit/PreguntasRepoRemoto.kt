package com.example.triviaapp.data.repositorio.reposRetrofit


import com.example.triviaapp.data.repositorio.interfacesRepo.IRepoPregunta
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitPreguntas
import com.example.triviaapp.modelo.PreguntaDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreguntasRepoRemoto(private val preguntaRetrofit : InterfazRetrofitPreguntas) : IRepoPregunta {
    override fun obtenerPreguntasTrivial(
        idTrivial: String,
        onSuccess: (List<PreguntaDTO>) -> Unit,

        onError: () -> Unit
    ) {
        preguntaRetrofit.listarPreguntas().enqueue(object : Callback<List<PreguntaDTO>> {

            override fun onResponse(
                call: Call<List<PreguntaDTO>>,
                response: Response<List<PreguntaDTO>>
            ) {
                if (response.isSuccessful) {
                    var lista = response.body()!!.filter { it.idTrivial == idTrivial }
                    if (!lista.isEmpty()) onSuccess(lista)
                    else onError()
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
                    if (response.isSuccessful) {
                        val pregunta = response.body()
                        if (pregunta != null)
                            onSuccess(pregunta)
                        else
                            onError()
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
    ) {var creadas = 0
        repeat(numPreg) {
            val nueva = PreguntaDTO(
                id = "",
                idTrivial = idTrivial,
                opcion1 = "",
                opcion2 = "",
                opcion3 = "",
                opcion4 = "",
                pregunta = "",
                respuestaCorrecta = 1
            )

            preguntaRetrofit.crearPregunta(nueva).enqueue(object : Callback<PreguntaDTO> {
                override fun onResponse(call: Call<PreguntaDTO>, response: Response<PreguntaDTO>) {
                    if (response.isSuccessful) {
                        creadas++
                        if (creadas == numPreg) onSuccess()
                    } else onError()
                }

                override fun onFailure(call: Call<PreguntaDTO>, t: Throwable) {
                    onError()
                }
            })
        }
    }

    override fun borrarPreguntas(
        idTrivial: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) { obtenerPreguntasTrivial(idTrivial,
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
        preguntaRetrofit.modificaPregunta(pregunta).enqueue(object : Callback<PreguntaDTO> {
            override fun onResponse(call: Call<PreguntaDTO>, response: Response<PreguntaDTO>) {
                if (response.isSuccessful) onSuccess()
                else onError()
            }

            override fun onFailure(call: Call<PreguntaDTO>, t: Throwable) {
                onError()
            }
        })
    }

    override fun respuestaCorrecta(
        respuesta: String,
        preguntaId: String,
        onSuccess: (Boolean) -> Unit,
        onError: () -> Unit
    ) {
        // Llamamos a la API para obtener la pregunta
        preguntaRetrofit.obtenerPregunta(preguntaId).enqueue(object : Callback<PreguntaDTO> {
            override fun onResponse(
                call: Call<PreguntaDTO>,
                response: Response<PreguntaDTO>
            ) {
                if (response.isSuccessful) {
                    val pregunta = response.body()
                    if (pregunta != null) {
                        // Comparamos la respuesta del usuario con la correcta
                        val esCorrecta = pregunta.respuestaCorrecta == respuesta.toIntOrNull()
                        onSuccess(esCorrecta)
                    } else {
                        onError() // No se encontró la pregunta
                    }
                } else {
                    onError() // Error HTTP
                }
            }

            override fun onFailure(call: Call<PreguntaDTO>, t: Throwable) {
                onError() // Error de red
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
