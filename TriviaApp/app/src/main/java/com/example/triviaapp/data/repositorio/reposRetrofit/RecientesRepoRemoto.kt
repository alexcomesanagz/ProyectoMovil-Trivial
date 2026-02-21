package com.example.triviaapp.data.repositorio.reposRetrofit

    import com.example.triviaapp.data.repositorio.interfacesRepo.RecientesRepoInterface
    import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitRecientes
    import com.example.triviaapp.modelo.RecientesDTO
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class RecientesRepoRemoto(private val inicioRetrofit: InterfazRetrofitRecientes, ) : RecientesRepoInterface {

        override fun anadirReciente(
            reciente: RecientesDTO,
            onSuccess: () -> Unit,
            onError: () -> Unit
        ) {
            obtenerRecientesPersona(reciente.idUsuario,{it->
                if(it.find {it.trivia==reciente.trivia}==null){
                    inicioRetrofit.crearInicio(reciente).enqueue(object : Callback<RecientesDTO> {
                        override fun onResponse(call: Call<RecientesDTO>, response: Response<RecientesDTO>) {
                            if (response.isSuccessful) {
                                onSuccess()
                            } else {
                                onError()
                            }
                        }

                        override fun onFailure(call: Call<RecientesDTO>, t: Throwable) {
                            onError()
                        }
                    })
                }
            },
            onError = {
                inicioRetrofit.crearInicio(reciente).enqueue(object : Callback<RecientesDTO> {
                    override fun onResponse(call: Call<RecientesDTO>, response: Response<RecientesDTO>) {
                        if (response.isSuccessful) {
                            onSuccess()
                        } else {
                            onError()
                        }
                    }

                    override fun onFailure(call: Call<RecientesDTO>, t: Throwable) {
                        onError()
                    }
                })
        })
    }


        override fun obtenerRecientesPersona(
            idCreador: String,
            onSuccess: (List<RecientesDTO>) -> Unit,
            onError: (List<RecientesDTO>) -> Unit
        ) {
            inicioRetrofit.listarInicio().enqueue(object : Callback<List<RecientesDTO>> {
                override fun onResponse(call: Call<List<RecientesDTO>>, response: Response<List<RecientesDTO>>) {
                    if (response.isSuccessful && response.body()!=null) {
                        onSuccess(response.body()!!.filter { it.idUsuario == idCreador })
                    } else {
                        onError(listOf())
                    }
                }
                override fun onFailure(call: Call<List<RecientesDTO>>, t: Throwable) {
                    onError(emptyList())
                }
            })
        }
    }