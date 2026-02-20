package com.example.triviaapp.modelo

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializer

class UsuarioDTO(
    val id: String="",
    var imagen: Int=0,
    @SerializedName("name")val nombre: String="",
    @SerializedName("email") val correo: String="",
    @SerializedName("passwd")val contrasena:String=""
)