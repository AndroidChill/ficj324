package com.example.starwars.auth.di

import com.example.starwars.auth.data.StarWarsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object NetworkStarWarsModule {
    @Provides
    fun provideStarWarsApiService(retrofit: Retrofit): StarWarsApiService = retrofit.create(
        StarWarsApiService::class.java)
}