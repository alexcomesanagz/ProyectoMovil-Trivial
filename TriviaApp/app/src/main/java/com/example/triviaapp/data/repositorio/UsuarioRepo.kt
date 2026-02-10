package com.example.triviaapp.data.repositorio

import com.example.triviaapp.modelo.UsuarioDTO

class UsuarioRepo {
    private val loged= LogueadoRepo()
    private val datos = arrayListOf(
        UsuarioDTO(id = "1",imagen =1, nombre = "Ana",correo = "ana@gmail.com",contrasena = "1"),
        UsuarioDTO(id = "2", imagen =1 , nombre = "Luis", correo = "luis@gmail.com", contrasena = "1")
    )

    fun obtener(correo: String, contasena: String, onSuccess: (UsuarioDTO?) -> Unit, onError: () -> Unit) {
        onSuccess(datos.find { it.correo == correo && it.contrasena==contasena })

    }

    fun registrar(nombre:String, correo: String, contasena: String, onSuccess: (UsuarioDTO?) -> Unit, onError: () -> Unit) {

        if(datos.find {it.correo == correo}==null) {
            datos.add(
                UsuarioDTO(
                    id = "3",
                    imagen = 1,
                    nombre = nombre,
                    contrasena = contasena,
                    correo = correo
                )
            )
            onSuccess(datos.find { it.correo==correo })
        }
        else onError
    }


    fun cambioImagenUsuario(id:String,imagen:Int, onSuccess: (UsuarioDTO?) -> Unit, onError: () -> Unit) {

        var usuario = datos.find { it.id == id }
        if(usuario == null) {
            onError()
            return
        }
        usuario.imagen = imagen;

        onSuccess(datos.find { it.id == id })
    }
}