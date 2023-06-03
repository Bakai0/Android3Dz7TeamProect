package com.example.android3dz7teamproect.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(

    @SerializedName("url")
    val url: String,

    @SerializedName("name")
    val name: String
)
