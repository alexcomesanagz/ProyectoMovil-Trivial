package com.example.triviaapp.data.repositorio.reposRetrofit

import androidx.room.RoomDatabase
import com.example.triviaapp.data.repositorio.interfacesRepo.UsuarioRepoInterf
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
import retrofit2.Callback
import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitUsuarios
import com.example.triviaapp.modelo.PreguntaDTO
import com.example.triviaapp.modelo.UsuarioDTO
import retrofit2.Call
import retrofit2.Response

class UsuarioRepoRemoto(private val usuarioRetrofit : InterfazRetrofitUsuarios) : UsuarioRepoInterf {
    override fun iniciarSesion(
        correo: String,
        contasena: String,
        onSuccess: (UsuarioDTO?) -> Unit,
        onError: () -> Unit
    ) {
        usuarioRetrofit.login(
            UsuarioDTO(
                nombre = correo,
                contrasena = contasena,
            )
        )
        .enqueue(object : Callback<UsuarioDTO> {
                override fun onResponse(call: Call<UsuarioDTO>, response: Response<UsuarioDTO>) {
                    if (response.isSuccessful && response.body() != null) {
                        onSuccess(response.body())
                    }
                }


                override fun onFailure(
                    call: Call<UsuarioDTO?>,
                    t: Throwable
                ) {
                    onError()
                }

            })
    }

        override fun registrar(
            nombre: String,
            correo: String,
            contasena: String,
            onSuccess: (UsuarioDTO?) -> Unit,
            onError: () -> Unit
        ) {
            usuarioRetrofit.crearUsuarios(
                UsuarioDTO(nombre = nombre,
                    correo=correo,
                    contrasena = contasena)
            ).enqueue(object : Callback<UsuarioDTO> {
                override fun onResponse(call: Call<UsuarioDTO>, response: Response<UsuarioDTO>) {
                    if (response.isSuccessful && response.body() != null) {
                        onSuccess(response.body())
                    }
                }


                override fun onFailure(
                    call: Call<UsuarioDTO?>,
                    t: Throwable
                ) {
                   onError()
                }

            })
        }

    }