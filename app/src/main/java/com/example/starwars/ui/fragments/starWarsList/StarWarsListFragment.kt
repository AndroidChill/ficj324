package com.example.starwars.ui.fragments.starWarsList

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwars.auth.di.DaggerMainComponent
import com.example.starwars.dataBase.StarWarsDataEntity
import com.example.starwars.databinding.FragmentStarWarsListBinding
import com.example.starwars.di.core.abstraction.BaseFragment
import com.example.starwars.ui.MainApplication
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsListData
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsListViewModel
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StarWarsListFragment : BaseFragment<FragmentStarWarsListBinding, StarWarsListViewModel>() {

    override val getViewBinding: (LayoutInflater) -> FragmentStarWarsListBinding
        get() = FragmentStarWarsListBinding::inflate

    override val getViewModelClass: Class<StarWarsListViewModel>
        get() = StarWarsListViewModel::class.java

    override fun setupDaggerComponent() {
        val authComponent = DaggerMainComponent
            .builder()
            .build()

        authComponent.inject(this)
    }

    private lateinit var adapter: StarWarsListAdapter

    override fun initUI() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.i("database", "error already exist")
        }

        adapter =
            StarWarsListAdapter(
                onClickFavourite = { name, isSelect ->
                    lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {

                        if (isSelect) {
                            val peopleName =
                                ((requireActivity()).application as? MainApplication)?.getDataBase()
                                    ?.getStarWarsDao()?.deleteDataByName(
                                        name
                                    )
                            val k = peopleName
                        } else {
                            val peopleName =
                                ((requireActivity()).application as? MainApplication)?.getDataBase()
                                    ?.getStarWarsDao()?.insertNewDataName(
                                        StarWarsDataEntity(name)
                                    )
                            val test = peopleName
                        }

                    }
                })

        binding.rvList.layoutManager = LinearLayoutManager(requireContext())

        binding.rvList.adapter = adapter

        lifecycleScope.launch {

            viewModel.state.collect {
                it.events.forEach { event ->
                    when (event) {
                        is StarWarsState.Event.LoadAll -> {
//                            val data = event.data.map {
//                                StarWarsListData(
//                                    name = it.name,
//                                    gender = it.gender,
//                                    starships = it.starships,
//                                    isHeart = false
//                                )
//                            }

//                            lifecycleScope.launch(Dispatchers.IO) {
//                                val name =
//                                    ((requireActivity()).application as? MainApplication)?.getDataBase()
//                                        ?.getStarWarsDao()?.getData()
//                                        ?.map { it.name } ?: emptyList()
//                                data.forEach { item ->
//                                    item.isHeart = name.contains(item.name)
//                                }
//                            }
//
//                            adapter.addData(data)
                            
                            adapter.submitData(event.data)
                        }

                        is StarWarsState.Event.ShowError -> {
                            Toast.makeText(context, "Ups, internet is missing", LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

    }

}