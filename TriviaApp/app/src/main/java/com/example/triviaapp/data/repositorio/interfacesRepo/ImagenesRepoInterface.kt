package com.example.triviaapp.data.repositorio.interfacesRepo

import com.example.triviaapp.modelo.ImagenDTO

interface ImagenesRepoInterface {
    fun obtenerImagen(
        categoria: String,
        onSuccess: (ImagenDTO) -> Unit,
        onError: () -> Unit
    )
}

