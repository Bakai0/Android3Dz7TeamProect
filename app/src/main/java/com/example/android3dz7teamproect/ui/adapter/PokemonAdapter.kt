package com.example.android3dz7teamproect.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3dz7teamproect.databinding.ItemPokemonBinding
import com.example.android3dz7teamproect.model.PokemonModel

class PokemonAdapter :
    ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(diffUtil) {

    inner class PokemonViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PokemonModel) {
            binding.itemPokemonHeight.text = item.name
            val pokemonId =
                item.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
                    .toInt()
            Glide.with(binding.itemCharacterImage.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonId.png")
                .into(binding.itemCharacterImage)
//            binding.itemCharacterStatus.text = item?.status
//            binding.itemCharacterImage.im
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<PokemonModel>() {
            override fun areItemsTheSame(
                oldItem: PokemonModel,
                newItem: PokemonModel
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: PokemonModel,
                newItem: PokemonModel
            ): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}