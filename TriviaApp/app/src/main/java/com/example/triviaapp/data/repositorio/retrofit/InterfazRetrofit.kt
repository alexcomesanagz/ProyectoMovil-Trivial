package com.example.triviaapp.data.repositorio.retrofit

import com.example.triviaapp.modelo.RecientesDTO
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.RecomendadosDTO
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

        /**
         * devuelve todos los trivias
         */
        @GET("/json/trivials")
        fun listarTrivials(): Call<List<TrivialDTO>>

        /**
         * devuelve el trivia de la id que se le pasase
         */
        @GET("/json/trivials/{id}")
        fun obtenerTrivial(@Path("id") id: String): Call<TrivialDTO>

        /**
         * crea un trivia
         */
        @PUT("/json/trivials")
        fun crearTrivial(@Body dto: TrivialDTO): Call<TrivialDTO>

        /**
         * borra un trivia
         */
        @DELETE("/json/trivials/{id}")
        fun borrarTrivial(@Path("id") id: String): Call<Void>
}

interface InterfazRetrofitRecientes {
        /**
         * obtiene todos los trivias recientes
         */
        @GET("/json/recientes")
        fun listarInicio(): Call<List<RecientesDTO>>

        /**
         * crea un nuevo trivia reciente
         */
        @PUT("/json/recientes")
        fun crearInicio(@Body dto: RecientesDTO): Call<RecientesDTO>

}

interface InterfazRetrofitPreguntas {

        /**
         * obtiene todas las preguntas
         */
        @GET("/json/preguntas")
        fun listarPreguntas(): Call<List<PreguntaDTO>>

        /**
         * obtiene la pregunta de la id que se pasase
         */
        @GET("/json/preguntas/{id}")
        fun obtenerPregunta(@Path("id") id: String): Call<PreguntaDTO>

        /**
         * crea una nueva pregunta
         */
        @PUT("/json/preguntas")
        fun crearPregunta(@Body dto: PreguntaDTO): Call<PreguntaDTO>

        /**
         * actualiza una pregunta
         */
        @POST("/json/preguntas/{id}")
        fun modificaPregunta(@Path("id")id:String,@Body dto: PreguntaDTO): Call<PreguntaDTO>

        /**
         * borra una pregunta
         */
        @DELETE("/json/preguntas/{id}")
        fun borrarPregunta(@Path("id") id: String): Call<Void>
}

interface InterfazRetrofitRespuestas {

        /**
         * obtiene todas las respuestas
         */
        @GET("/json/respuestas")
        fun listarRespuestas(): Call<List<RespuestaDTO>>

        /**
         * obtiene una las respuesta
         */
        @GET("/json/respuestas/{id}")
        fun obtenerRespuesta(@Path("id") id: String): Call<RespuestaDTO>

        /**
         * crea una respuesta
         */
        @PUT("/json/respuestas")
        fun crearRespuesta(@Body dto: RespuestaDTO): Call<RespuestaDTO>

        /**
         * actualiza una respuesta
         */
        @POST("/json/respuestas/{id}")
        fun modificaRespuesta(@Path("id") id: String, @Body dto: RespuestaDTO): Call<RespuestaDTO>
}

interface InterfazRetrofitUsuarios {
        /**
         * inicia sesion
         */
        @POST("auth/login")
        fun login(@Body dto: UsuarioDTO): Call<UsuarioDTO>
        /**
         * registra un usuario
         */
        @POST("auth/register")
        fun crearUsuarios(@Body dto: UsuarioDTO): Call<UsuarioDTO>
}

interface InterfazRetrofitRecomendados {
        /**
         * obtiene todos los recomendados
         */
        @GET("/json/recomendados")
        fun listarRecomendados(): Call<List<RecomendadosDTO>>

}