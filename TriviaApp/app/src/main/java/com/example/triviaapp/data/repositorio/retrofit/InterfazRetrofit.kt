package com.example.triviaapp.data.repositorio.retrofit

import androidx.room.Delete
import com.example.triviaapp.modelo.ImagenDTO
import com.example.triviaapp.modelo.InicioDTO
import com.example.triviaapp.modelo.PreferenceDTO
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RecomendadosDTO
import com.example.triviaapp.modelo.RespuestaDTO
import com.example.triviaapp.modelo.TrivialDTO
import com.example.triviaapp.modelo.UsuarioDTO
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface InterfazRetrofitTrivias {

        @GET("/json/trivials")
        fun listarTrivials(): Call<List<TrivialDTO>>

        @GET("/json/trivials/{id}")
        fun obtenerTrivial(@Path("id") id: String): Call<TrivialDTO>

        @PUT("/json/trivials")
        fun crearTrivial(@Body dto: TrivialDTO): Call<TrivialDTO>

        @DELETE("/json/trivials/{id}")
        fun borrarTrivial(@Path("id") id: String): Call<Void>
}


interface InterfazRetrofitInicio {
        @GET("/json/inicio")
        fun listarInicio(): Call<List<InicioDTO>>

        @PUT("/json/inicio")
        fun crearInicio(@Body dto: InicioDTO): Call<InicioDTO>

}

interface InterfazRetrofitPreguntas {
        @GET("/json/preguntas")
        fun listarPreguntas(): Call<List<PreguntaDTO>>

        @GET("/json/preguntas/{id}")
        fun obtenerPregunta(@Path("id") id: String): Call<PreguntaDTO>

        @PUT("/json/preguntas")
        fun crearPregunta(@Body dto: PreguntaDTO): Call<PreguntaDTO>

        @POST("/json/preguntas/{id}")
        fun modificaPregunta(@Path("id")id:String,@Body dto: PreguntaDTO): Call<PreguntaDTO>
        @DELETE("/json/preguntas/{id}")
        fun borrarPregunta(@Path("id") id: String): Call<Void>
}
interface InterfazRetrofitRespuestas {
        @GET("/json/respuestas")
        fun listarRespuestas(): Call<List<RespuestaDTO>>

        @GET("/json/respuestas/{id}")
        fun obtenerRespuesta(@Path("id") id: String): Call<RespuestaDTO>

        @PUT("/json/respuestas")
        fun crearRespuesta(@Body dto: RespuestaDTO): Call<RespuestaDTO>

        @POST("/json/respuestas/{id}")
        fun modificaRespuesta(@Path("id") id: String, @Body dto: RespuestaDTO): Call<RespuestaDTO>
}
interface InterfazRetrofitUsuarios {
        @POST("auth/login")
        fun login(@Body dto: UsuarioDTO): Call<UsuarioDTO>
        @POST("auth/register")
        fun crearUsuarios(@Body dto: UsuarioDTO): Call<UsuarioDTO>
}

interface InterfazRetrofitRecomendados {
        @GET("/json/recomendados")
        fun listarRecomendados(): Call<List<RecomendadosDTO>>

}