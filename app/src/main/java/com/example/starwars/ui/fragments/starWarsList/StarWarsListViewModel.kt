package com.example.starwars.ui.fragments.starWarsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.auth.data.People
import com.example.starwars.dataBase.StarWarsIdData
import com.example.starwars.ui.fragments.StarWarsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class StarWarsListViewModel @Inject constructor(
    private val starWarsUseCase: StarWarsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<StarWarsState>(StarWarsState())
    val state = _state.asStateFlow()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _state.update { oldState ->
            oldState.copy(
                events = oldState.events + StarWarsState.Event.ShowError
            )

        }
    }

    init {
        viewModelScope.launch {
                getAllPeoples(/*2*/)
        }

    }

    //todo hmmmmmmmmm
    fun handleAction(action: StarWarsState.Action) {

        when (action) {
            is StarWarsState.Action.OnClickFavourite -> {
                val newFavor = StarWarsIdData(name = action.name)
            }
        }
    }

    suspend fun getAllPeoples(/*page: Int*/) {
        viewModelScope.launch(coroutineExceptionHandler + CoroutineName("getAllCocktails")) {
            val response = starWarsUseCase.peoplesList(/*page*/)
            _state.update { oldState ->
                oldState.copy(
                    events = oldState.events + StarWarsState.Event.LoadAll(
                        response.peoples
                    )
                )
            }
        }

    }
}

data class StarWarsState(
    val events: List<Event> = emptyList()
) {

    sealed class Event {
        class LoadAll(val data: List<People>) : Event()

        object ShowError : Event()
    }

    sealed class Action {

        class OnClickFavourite(val name: String) : Action()
    }


}