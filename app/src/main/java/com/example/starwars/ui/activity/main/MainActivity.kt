package com.example.starwars.ui.activity.main

import android.view.LayoutInflater
import com.example.starwars.R
import com.example.starwars.auth.di.DaggerMainComponent
import com.example.starwars.databinding.ActivityMainBinding
import com.example.starwars.di.core.abstraction.BaseActivity
import com.example.starwars.ui.fragments.mainFragment.MainFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val getViewBinding: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override val getViewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun setupDaggerComponent() {
        val authComponent = DaggerMainComponent
            .builder()
            .build()

        authComponent.inject(this)
    }

    override fun initUI() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()

    }

}