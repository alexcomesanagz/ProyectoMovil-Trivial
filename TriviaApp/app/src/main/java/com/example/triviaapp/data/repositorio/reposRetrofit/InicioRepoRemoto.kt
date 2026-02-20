package com.example.triviaapp.data.repositorio.reposRetrofit

    import com.example.triviaapp.data.repositorio.interfacesRepo.InicioRepoInterface
    import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitInicio
    import com.example.triviaapp.data.repositorio.retrofit.InterfazRetrofitTrivias
    import com.example.triviaapp.modelo.InicioDTO
    import com.example.triviaapp.modelo.TrivialDTO
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class InicioRepoRemoto(private val inicioRetrofit: InterfazRetrofitInicio) : InicioRepoInterface {
        override fun anadirRecientes(
            reciente: InicioDTO,
            onSuccess: () -> Unit,
            onError: () -> Unit
        ) {
            inicioRetrofit.crearInicio(reciente).enqueue(object : Callback<InicioDTO> {
                override fun onResponse(call: Call<InicioDTO>, response: Response<InicioDTO>) {
                    if (response.isSuccessful) {
                        onSuccess()
                    } else {
                        onError()
                    }
                }

                override fun onFailure(call: Call<InicioDTO>, t: Throwable) {
                    onError()
                }
            })
        }

        override fun obtenerRecientesPersona(
            idCreador: String,
            onSuccess: (List<InicioDTO>) -> Unit,
            onError: (List<InicioDTO>) -> Unit
        ) {
            inicioRetrofit.listarInicio().enqueue(object : Callback<List<InicioDTO>> {
                override fun onResponse(call: Call<List<InicioDTO>>, response: Response<List<InicioDTO>>) {
                    val lista = response.body()?.filter { it.idUsiario == idCreador } ?: emptyList()
                    if (response.isSuccessful && lista.isNotEmpty()) {
                        onSuccess(lista)
                    } else {
                        onError(lista)
                    }
                }

                override fun onFailure(call: Call<List<InicioDTO>>, t: Throwable) {
                    onError(emptyList())
                }
            })
        }
    }