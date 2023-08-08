package com.example.starwars.auth.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwars.di.core.annotation.ViewModelKey
import com.example.starwars.di.core.factory.ViewModelFactory
import com.example.starwars.ui.activity.main.MainViewModel
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StarWarsListViewModel::class)
    internal abstract fun provideStarWarsViewModel(viewModel: StarWarsListViewModel): ViewModel
    
    companion object {
        @Provides
        @JvmStatic
        internal fun provideViewModelFactory(viewModelMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
            return ViewModelFactory(viewModelMap)
        }
    }

}