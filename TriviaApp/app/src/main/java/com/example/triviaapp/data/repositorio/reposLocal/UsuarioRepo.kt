package com.example.triviaapp.data.repositorio.reposLocal

import com.example.triviaapp.R
import com.example.triviaapp.data.repositorio.interfacesRepo.UsuarioRepoInterf
import com.example.triviaapp.modelo.UsuarioDTO



class UsuarioRepo : UsuarioRepoInterf {
    private val datos = arrayListOf(
        UsuarioDTO(
            id = "1",
            imagen = R.drawable.trivia,
            nombre = "Ana",
            correo = "ana@gmail.com",
            contrasena = "1"
        ),
        UsuarioDTO(
            id = "2",
            imagen = R.drawable.trivia,
            nombre = "Luis",
            correo = "luis@gmail.com",
            contrasena = "1"
        )
    )

    override fun iniciarSesion(
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO?) -> Unit,
        onError: () -> Unit
    ) {
        val usuario = datos.find {
            it.correo == correo && it.contrasena == contasena
        }
        if (usuario != null) {
            onSuccess(usuario)
        } else {
            onError()
        }
    }

    override fun registrar(
        nombre: String,
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO?) -> Unit,
        onError: () -> Unit
    ) {

        if (datos.find { it.correo == correo } == null) {

            datos.add(
                UsuarioDTO(
                    id = "" + datos.size,
                    imagen = R.drawable.trivia,
                    nombre = nombre,
                    contrasena = contasena,
                    correo = correo
                )
            )
            onSuccess(datos.find { it.correo == correo }!!)
        } else onError
    }


//    fun cambioImagenUsuario(id:String,imagen:Int, onSuccess: (UsuarioDTO?) -> Unit, onError: () -> Unit) {
//
//        var usuario = datos.find { it.id == id }
//        if(usuario == null) {
//            onError()
//            return
//        }
//        usuario.imagen = imagen;
//
//        onSuccess(datos.find { it.id == id })
//    }
}