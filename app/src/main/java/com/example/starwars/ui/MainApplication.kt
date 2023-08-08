package com.example.starwars.ui

import com.example.starwars.auth.BaseApplication
import com.example.starwars.dataBase.DatabaseClient
import com.example.starwars.di.component.ApplicationComponent
import com.example.starwars.di.component.DaggerApplicationComponent
import com.example.starwars.di.module.ApplicationModule


class MainApplication : BaseApplication() {

    lateinit var databaseClient: DatabaseClient
    
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
    
    override fun onCreate() {
        super.onCreate()
        injectDependencies()

        databaseClient = DatabaseClient.getInstance(applicationContext)

    }
    
    fun getDataBase() = databaseClient.appDatabase

    
    private fun injectDependencies() {
        appComponent.inject(this)
    }
    
}