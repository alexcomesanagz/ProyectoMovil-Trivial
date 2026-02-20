package com.example.triviaapp.data.repositorio.reposRetrofit

import com.example.triviaapp.data.repositorio.interfacesRepo.RecomendadosRepoInterfaz
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitRecomendados
import com.example.triviaapp.modelo.RecomendadosDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecomendadosRepoRetrofit(private val recomendadosRetrofit: InterfazRetrofitRecomendados) : RecomendadosRepoInterfaz {

    override fun obtenerRecomendadosPersona(
        onSuccess: (List<RecomendadosDTO>) -> Unit,
        onError: (List<RecomendadosDTO>) -> Unit
    ) {
        {
            {
                recomendadosRetrofit.listarRecomendados().enqueue(object : Callback<List<RecomendadosDTO>> {
                    override fun onResponse(
                        call: Call<List<RecomendadosDTO>>,
                        response: Response<List<RecomendadosDTO>>
                    ) {
                        val lista = response.body() ?: emptyList()
                        if (response.isSuccessful && !lista.isEmpty()) {
                            onSuccess(lista)
                        } else {
                            onError(lista)
                        }
                    }

                    override fun onFailure(call: Call<List<RecomendadosDTO>>, t: Throwable) {
                        onError(emptyList())
                    }
                })
            }
        }
    }
}