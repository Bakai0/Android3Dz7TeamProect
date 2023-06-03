package com.example.android3dz7teamproect.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.android3dz7teamproect.App
import com.example.android3dz7teamproect.repozitory.PokemonRepozitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private var pokemonRepository:PokemonRepozitory
): ViewModel() {

    fun fetchPokemon() = pokemonRepository.fetchPokemon()

}