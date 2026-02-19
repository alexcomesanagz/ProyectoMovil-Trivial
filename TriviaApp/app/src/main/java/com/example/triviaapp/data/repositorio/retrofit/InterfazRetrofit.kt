package com.example.triviaapp.data.repositorio.retrofit

import androidx.room.Delete
import com.example.triviaapp.modelo.TrivialDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InterfazRetrofitTrivias {

        @GET("json/trivials")
        fun listarTrivials(): Call<List<TrivialDTO>>

        @GET("json/trivials/{id}")
        fun obtenerTrivial(@Path("id") id: String): Call<TrivialDTO>

        @POST("json/trivials")
        fun crearTrivial(@Body dto: TrivialDTO): Call<TrivialDTO>

        @DELETE("json/trivials/{id}")
        fun borrarTrivial(@Body dto: TrivialDTO): Call<TrivialDTO>
}

        interface InterfazRetrofitImagenes {
                @GET("json/imagenes")
                fun listarImagenes(): Call<List<TrivialDTO>>

                @GET("json/imagenes/{id}")
                fun obtenerImagenes(@Path("id") id: String): Call<TrivialDTO>

                @POST("json/imagenes")
                fun crearImagenes(@Body dto: TrivialDTO): Call<TrivialDTO>

                @DELETE("json/imagenes/{id}")
                fun borrarImagenes(@Body dto: TrivialDTO)
        }

interface InterfazRetrofitInicio {
        @GET("json/inicio")
        fun listarInicio(): Call<List<TrivialDTO>>

        @GET("json/inicio/{id}")
        fun obtenerInicio(@Path("id") id: String): Call<TrivialDTO>

        @POST("json/inicio")
        fun crearInicio(@Body dto: TrivialDTO): Call<TrivialDTO>

        @DELETE("json/inicio/{id}")
        fun borrarInicio(@Body dto: TrivialDTO)
}

interface InterfazRetrofitPreguntas {
        @GET("json/preguntas")
        fun listarPreguntas(): Call<List<TrivialDTO>>

        @GET("json/preguntas/{id}")
        fun obtenerPreguntas(@Path("id") id: String): Call<TrivialDTO>

        @POST("json/preguntas")
        fun crearPreguntas(@Body dto: TrivialDTO): Call<TrivialDTO>

        @DELETE("json/preguntas/{id}")
        fun borrarPreguntas(@Body dto: TrivialDTO): Call<TrivialDTO>
}
interface InterfazRetrofitRespuestas {
        @GET("json/respuestas")
        fun listarRespuestas(): Call<List<TrivialDTO>>

        @GET("json/respuestas/{id}")
        fun obtenerRespuestas(@Path("id") id: String): Call<TrivialDTO>

        @POST("json/respuestas")
        fun crearRespuestas(@Body dto: TrivialDTO): Call<TrivialDTO>

        @DELETE("json/respuestas/{id}")
        fun borrarRespuestas(@Body dto: TrivialDTO): Call<TrivialDTO>
}
interface InterfazRetrofitUsuarios {
        @GET("json/usuarios")
        fun listarUsuarios(): Call<List<TrivialDTO>>
        @GET("json/usuarios/{id}")
        fun obtenerUsuarios(@Path("id") id: String): Call<TrivialDTO>
        @POST("json/usuarios")
        fun crearUsuarios(@Body dto: TrivialDTO): Call<TrivialDTO>
        @DELETE("json/usuarios/{id}")
        fun borrarUsuarios(@Body dto: TrivialDTO): Call<TrivialDTO>
}