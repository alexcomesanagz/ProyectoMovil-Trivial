package com.example.triviaapp.data.repositorio

import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofit
import com.example.triviaapp.modelo.ImagenDTO

class ImagenesRepoRemoto(private val api : InterfazRetrofit) : ImagenesRepoInterface{
    override fun obtenerImagen(
        categoria: String,
        onSuccess: (ImagenDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

}