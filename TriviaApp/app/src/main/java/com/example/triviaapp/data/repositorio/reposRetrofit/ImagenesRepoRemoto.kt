package com.example.triviaapp.data.repositorio.reposRetrofit

import com.example.triviaapp.data.repositorio.interfacesRepo.ImagenesRepoInterface
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitImagenes
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import com.example.triviaapp.modelo.ImagenDTO

class ImagenesRepoRemoto(private val ImagenRetrofit : InterfazRetrofitImagenes) : ImagenesRepoInterface {
    override fun obtenerImagen(
        categoria: String,
        onSuccess: (ImagenDTO) -> Unit,
        onError: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

}