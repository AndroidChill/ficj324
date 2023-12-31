package com.example.starwars.di.core.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseActivity <V : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    private var _binding: V? = null
    protected val binding: V
        get() = requireNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var _viewModel: VM
    protected val viewModel: VM
        get() = _viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setupDaggerComponent()
        super.onCreate(savedInstanceState)

        if (_binding == null) {
            _binding = getViewBinding(layoutInflater)
        }
        setContentView(_binding?.root)
        _viewModel = ViewModelProvider(this, viewModelFactory)[getViewModelClass]

        initUI()
    }

    open fun initUI() {}

    abstract fun setupDaggerComponent()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract val getViewBinding: (LayoutInflater) -> V
    abstract val getViewModelClass: Class<VM>
}