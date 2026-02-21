package com.example.triviaapp.data.repositorio.retrofit

    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

object Network {
        private const val BASE_URL = "http://10.0.2.2:5131"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val triviaRetrofit: InterfazRetrofitTrivias = retrofit.create(InterfazRetrofitTrivias::class.java)
        val respuestaRetrofit: InterfazRetrofitRespuestas = retrofit.create(InterfazRetrofitRespuestas::class.java)
        val preguntaRetrofit: InterfazRetrofitPreguntas = retrofit.create(InterfazRetrofitPreguntas::class.java)
        val recientesRetrofit: InterfazRetrofitRecientes = retrofit.create(InterfazRetrofitRecientes::class.java)
        val usuarioRetrofit: InterfazRetrofitUsuarios = retrofit.create(InterfazRetrofitUsuarios::class.java)

        val recomendadosRetrofit: InterfazRetrofitRecomendados = retrofit.create(InterfazRetrofitRecomendados::class.java)

}