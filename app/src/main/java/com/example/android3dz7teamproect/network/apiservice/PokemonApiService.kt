package com.example.android3dz7teamproect.network.apiservice

import com.example.android3dz7teamproect.model.PokemonModel
import com.example.android3dz7teamproect.model.PokemonResponce
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiService {
    @GET("/api/v2/pokemon")
    fun fetchPokemonApiService(
    ): Call<PokemonResponce<PokemonModel>>
}