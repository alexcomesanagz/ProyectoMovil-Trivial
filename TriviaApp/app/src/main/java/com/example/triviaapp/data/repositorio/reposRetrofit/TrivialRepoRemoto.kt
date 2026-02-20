package com.example.triviaapp.data.repositorio.reposRetrofit

import com.example.triviaapp.data.repositorio.interfacesRepo.TrivialRepoInterface
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.TrivialDTO
import com.example.triviaapp.modelo.UsuarioDTO
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class TrivialRepoRemoto(private val triviaRetrofit : InterfazRetrofitTrivias) : TrivialRepoInterface {
    override fun obtenerTrivialsPersona(
        idCreador: String,
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: (List<TrivialDTO>) -> Unit
    ) {
       triviaRetrofit.listarTrivials()
           .enqueue(object : retrofit2.Callback<List<TrivialDTO>> {
               override fun onResponse(call: Call<List<TrivialDTO>>, response: Response<List<TrivialDTO>>) {
                   if (response.isSuccessful && response.body() != null) {
                       val lista = response.body()!!.filter {it.idCreador==idCreador}
                       onSuccess(lista)
                   }
                   onError(listOf())
               }


               override fun onFailure(
                   call: Call<List<TrivialDTO>>,
                   t: Throwable
               ) {
                   onError(listOf())
               }

           })
    }

    override fun crearTrivia(
        idCreador: String,
        nombre: String,
        categoria: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    ) {
        triviaRetrofit.crearTrivial(TrivialDTO(
            idCreador = idCreador,
            nombre = nombre,
            categoria = categoria
        ))
            .enqueue(object : retrofit2.Callback<TrivialDTO> {
                override fun onResponse(call: Call<TrivialDTO>, response: Response<TrivialDTO>) {
                    if (response.isSuccessful && response.body() != null && response.body()?.id !=null) {
                        val trivia=response.body()
                        if(trivia!=null)onSuccess(trivia)
                    }
                    onError()
                }


                override fun onFailure(
                    call: Call<TrivialDTO>,
                    t: Throwable
                ) {
                    onError()
                }

            })
    }

    override fun borrar(
        idTrivia: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        triviaRetrofit.borrarTrivial(id = idTrivia)
            .enqueue(object : retrofit2.Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                      onSuccess()
                    }
                    onError()
                }


                override fun onFailure(
                    call: Call<Void>,
                    t: Throwable
                ) {
                    onError()
                }

            })
    }

    override fun leerTodo(
        onSuccess: (List<TrivialDTO>) -> Unit,
        onError: () -> Unit
    ) {
        triviaRetrofit.listarTrivials()
            .enqueue(object : retrofit2.Callback<List<TrivialDTO>> {
                override fun onResponse(call: Call<List<TrivialDTO>>, response: Response<List<TrivialDTO>>) {
                    if (response.isSuccessful && response.body() != null) {
                        val lista = response.body()
                        onSuccess(lista!!)
                    }
                    onError()
                }


                override fun onFailure(
                    call: Call<List<TrivialDTO>>,
                    t: Throwable
                ) {
                    onError()
                }

            })
    }

    override fun obtenerTrivial(
        idTrivia: String,
        onSuccess: (TrivialDTO) -> Unit,
        onError: () -> Unit
    ) {
        triviaRetrofit.obtenerTrivial(id = idTrivia)
            .enqueue(object : retrofit2.Callback<TrivialDTO> {
                override fun onResponse(call: Call<TrivialDTO>, response: Response<TrivialDTO>) {
                    if (response.isSuccessful && response.body() !=null) {
                        val trivia=response.body()
                       if (trivia!=null) onSuccess(trivia)
                    }
                    onError()
                }


                override fun onFailure(
                    call: Call<TrivialDTO>,
                    t: Throwable
                ) {
                    onError()
                }

            })
    }
}