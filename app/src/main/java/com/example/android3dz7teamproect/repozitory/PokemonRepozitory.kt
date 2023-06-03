package com.example.android3dz7teamproect.repozitory

import androidx.lifecycle.MutableLiveData
import com.example.android3dz7teamproect.model.PokemonModel
import com.example.android3dz7teamproect.model.PokemonResponce
import com.example.android3dz7teamproect.network.RetrofitClient
import com.example.android3dz7teamproect.network.apiservice.PokemonApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PokemonRepozitory @Inject constructor(
    private val pokemonApiService: PokemonApiService
) {
    fun fetchPokemon(): MutableLiveData<PokemonResponce<PokemonModel>> {
        val data: MutableLiveData<PokemonResponce<PokemonModel>> = MutableLiveData()
        pokemonApiService.fetchPokemonApiService()
            .enqueue(object : Callback<PokemonResponce<PokemonModel>> {

                override fun onResponse(
                    call: Call<PokemonResponce<PokemonModel>>,
                    response: Response<PokemonResponce<PokemonModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<PokemonResponce<PokemonModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}

