package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.interfacesRepo.ImagenesRepoInterface
import com.example.triviaapp.modelo.ImagenDTO

class ImagenesRepo: ImagenesRepoInterface {
    private val datos=listOf<ImagenDTO>(
        ImagenDTO("Terror",R.drawable.terror),
        ImagenDTO("Accion", R.drawable.accion),
        ImagenDTO("Puzzle", R.drawable.puzzle),
        ImagenDTO("Tactico", R.drawable.tactico),
        ImagenDTO("Mal", R.drawable.mal),
        ImagenDTO("Bien", R.drawable.bien)
        )
    override fun obtenerImagen(
        categoria: String,
        onSuccess: (ImagenDTO) -> Unit,
        onError: () -> Unit
    ) {
        val imagen=datos.find {it.categoria==categoria}
        if (imagen!=null){
            onSuccess(imagen)
        }
        else onError()
    }
}