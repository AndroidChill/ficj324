package com.example.starwars.di.core.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<V : ViewBinding, VM : ViewModel> : Fragment() {

    private var _binding: V? = null
    val binding: V
        get() = requireNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var _viewModel: VM
    protected val viewModel: VM
        get() = _viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setupDaggerComponent()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null) {
            _binding = getViewBinding(layoutInflater)
        }

        _viewModel = ViewModelProvider(this, viewModelFactory)[getViewModelClass]


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    open fun initUI() {}

    abstract fun setupDaggerComponent()


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract val getViewBinding: (LayoutInflater) -> V
    abstract val getViewModelClass: Class<VM>
}