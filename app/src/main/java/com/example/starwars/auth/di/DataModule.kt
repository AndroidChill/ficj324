package com.example.starwars.auth.di

import com.example.starwars.auth.data.StarWarsApiService
import com.example.starwars.auth.data.StarWarsNetworkDataSource
import com.example.starwars.ui.fragments.StarWarsUseCase
import com.example.starwars.ui.fragments.StarWarsRepository
import dagger.Module
import dagger.Provides

@Module
object DataModule {

    @Provides
    fun provideStarWarsNetworkDataSource(starWarsApiService: StarWarsApiService): StarWarsNetworkDataSource =
        StarWarsNetworkDataSource(starWarsApiService)

    @Provides
    fun provideStarWarsUseCase(starWarsRepository: StarWarsRepository): StarWarsUseCase =
        StarWarsUseCase(starWarsRepository)
}