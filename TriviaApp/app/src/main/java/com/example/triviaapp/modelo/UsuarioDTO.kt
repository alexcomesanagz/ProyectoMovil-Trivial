package com.example.triviaapp.modelo

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializer

/**
 * objeto que representa al usuario
 * @param nombre nombre del usuario
 * @param correo correo del usuario
 * @param contrasena contraseña del usuario
 */
class UsuarioDTO(
    val id: String="",
    var imagen: Int=0,
    @SerializedName("name")val nombre: String="",
    @SerializedName("email") val correo: String="",
    @SerializedName("passwd")val contrasena:String=""
)