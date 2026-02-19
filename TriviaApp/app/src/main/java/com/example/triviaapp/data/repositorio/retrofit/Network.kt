package com.example.triviaapp.data.repositorio.retrofit

    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

object Network {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApiService: InterfazRetrofit = retrofit.create(InterfazRetrofit::class.java)

}