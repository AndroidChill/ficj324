package com.example.starwars.auth.di

import com.example.starwars.ui.activity.main.MainActivity
import com.example.starwars.ui.fragments.starWarsList.StarWarsListFragment
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        NetworkStarWarsModule::class,
        DataModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: StarWarsListFragment)



}