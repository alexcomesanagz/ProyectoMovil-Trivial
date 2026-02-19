package com.example.triviaapp.data.repositorio

import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.ImagenDTO

class ImagenesRepoRemoto(private val api : InterfazRetrofitTrivias) : ImagenesRepoInterface{
    override fun obtenerImagen(
        categoria: String,
        onSuccess: (ImagenDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

}