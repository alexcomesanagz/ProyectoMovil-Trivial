package com.example.triviaapp.data.repositorio.retrofit

import androidx.room.Delete
import com.example.triviaapp.modelo.ImagenDTO
import com.example.triviaapp.modelo.InicioDTO
import com.example.triviaapp.modelo.PreferenceDTO
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RespuestaDTO
import com.example.triviaapp.modelo.TrivialDTO
import com.example.triviaapp.modelo.UsuarioDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
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
        fun listarImagenes(): Call<List<ImagenDTO>>

        @GET("json/imagenes/{id}")
        fun obtenerImagenes(@Path("id") id: String): Call<ImagenDTO>

}

interface InterfazRetrofitInicio {
        @GET("json/inicio")
        fun listarInicio(): Call<List<InicioDTO>>

        @GET("json/inicio/{id}")
        fun obtenerInicio(@Path("id") id: String): Call<InicioDTO>

        @POST("json/inicio")
        fun crearInicio(@Body dto: InicioDTO): Call<InicioDTO>

}

interface InterfazRetrofitPreguntas {
        @GET("json/preguntas")
        fun listarPreguntas(): Call<List<PreguntaDTO>>

        @GET("json/preguntas/{id}")
        fun obtenerPreguntas(@Path("id") id: String): Call<PreguntaDTO>

        @POST("json/preguntas")
        fun crearPreguntas(@Body dto: PreguntaDTO): Call<PreguntaDTO>

        @DELETE("json/preguntas/{id}")
        fun borrarPreguntas(@Body dto: PreguntaDTO)
}
interface InterfazRetrofitRespuestas {
        @GET("json/respuestas")
        fun listarRespuestas(): Call<List<RespuestaDTO>>

        @GET("json/respuestas/{id}")
        fun obtenerRespuestas(@Path("id") id: String): Call<RespuestaDTO>

        @POST("json/respuestas")
        fun crearRespuestas(@Body dto: RespuestaDTO): Call<RespuestaDTO>

}
interface InterfazRetrofitUsuarios {
        @GET("json/usuarios")
        fun listarUsuarios(): Call<List<UsuarioDTO>>
        @GET("json/usuarios/{id}")
        fun obtenerUsuarios(@Path("id") id: String): Call<UsuarioDTO>
        @POST("json/usuarios")
        fun crearUsuarios(@Body dto: UsuarioDTO): Call<UsuarioDTO>
}