package com.example.triviaapp.data.repositorio.retrofit

import com.example.triviaapp.modelo.TrivialDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InterfazRetrofit {

        @GET("estudiantes")
        fun listar(): Call<List<TrivialDTO>>
        @GET("estudiantes/{id}")
        fun obtener(@Path("id") id: String): Call<TrivialDTO>
        @POST("estudiantes")
        fun crear(@Body dto: TrivialDTO): Call<TrivialDTO>

}