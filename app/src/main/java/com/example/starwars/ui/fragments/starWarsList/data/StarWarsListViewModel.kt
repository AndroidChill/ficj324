package com.example.starwars.ui.fragments.starWarsList.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.starwars.auth.data.People
import com.example.starwars.dataBase.StarWarsIdData
import com.example.starwars.ui.fragments.StarWarsUseCase
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsState.Action
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsState.Action.OnClickFavourite
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsState.Event.LoadAll
import com.example.starwars.ui.fragments.starWarsList.data.StarWarsState.Event.ShowError
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class StarWarsListViewModel @Inject constructor(
    private val starWarsUseCase: StarWarsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<StarWarsState>(StarWarsState())
    val state = _state.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _state.update { oldState ->
            oldState.copy(
                events = oldState.events + ShowError
            )

        }
    }

    init {
        viewModelScope.launch {
                getAllPeoples(/*2*/)
        }

    }

    fun handleAction(action: Action) {

        when (action) {
            is OnClickFavourite -> {
                val newFavor = StarWarsIdData(name = action.name)
            }
        }
    }
    
    private fun getAllPeoples(/*page: Int*/) {
        viewModelScope.launch(coroutineExceptionHandler + CoroutineName("getAllCocktails")) {
            starWarsUseCase.peoplesList(/*page*/).collectLatest { item ->
                _state.update { oldState ->
                    oldState.copy(
                        events = oldState.events + LoadAll(
                            item
                        )
                    )
                }
            }
            
        }

    }
}

