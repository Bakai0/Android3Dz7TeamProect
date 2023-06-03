package com.example.android3dz7teamproect.ui.fragment

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android3dz7teamproect.R
import com.example.android3dz7teamproect.base.BaseFragment
import com.example.android3dz7teamproect.databinding.FragmentPokemonBinding
import com.example.android3dz7teamproect.model.PokemonModel
import com.example.android3dz7teamproect.model.PokemonResponce
import com.example.android3dz7teamproect.ui.adapter.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment :
    BaseFragment<FragmentPokemonBinding, PokemonViewModel>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel by viewModels <PokemonViewModel>()
    private var pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        binding.recViewPokemonFragment.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
            Toast.makeText(requireContext(), "vghvmv", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchPokemon1().observe(viewLifecycleOwner) {
                pokemonAdapter.submitList(it.results)
            }
        }
    }
}