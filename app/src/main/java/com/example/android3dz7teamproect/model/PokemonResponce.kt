package com.example.android3dz7teamproect.model

import com.google.gson.annotations.SerializedName

data class PokemonResponce<T>(

    @SerializedName("id")
    val id: Int,

    @SerializedName("weight")
    val weight: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("results")
    val results: List<T>
)
