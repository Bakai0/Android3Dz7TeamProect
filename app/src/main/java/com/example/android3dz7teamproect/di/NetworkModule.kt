package com.example.android3dz7teamproect.di

import com.example.android3dz7teamproect.network.RetrofitClient
import com.example.android3dz7teamproect.network.apiservice.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providePokemonApiService(): PokemonApiService {
        return retrofitClient.providePokemonApiService()
    }
}