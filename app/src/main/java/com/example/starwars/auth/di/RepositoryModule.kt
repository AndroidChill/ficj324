package com.example.starwars.auth.di

import com.example.starwars.auth.data.StarWarsRepositoryImpl
import com.example.starwars.ui.fragments.StarWarsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindStarWarsRepositoryImpl(repositoryImpl: StarWarsRepositoryImpl): StarWarsRepository

}