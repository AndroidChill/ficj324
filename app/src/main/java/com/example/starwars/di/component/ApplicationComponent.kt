package com.example.starwars.di.component

import android.app.Application
//import com.example.demonstration_project_cocktails.di.core.scope.CoreComponent
import com.example.starwars.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    fun inject(application: Application)

}