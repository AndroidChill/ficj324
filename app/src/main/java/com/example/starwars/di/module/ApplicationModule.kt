package com.example.starwars.di.module

import android.content.Context
import com.example.starwars.auth.ApplicationContext
import com.example.starwars.ui.MainApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: MainApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }

}