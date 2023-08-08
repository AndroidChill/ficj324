package com.example.starwars.ui.fragments.starWarsList.data

import androidx.paging.PagingData
import com.example.starwars.auth.data.People

data class StarWarsState(
    val events: List<Event> = emptyList()
) {
    
    sealed class Event {
        class LoadAll(val data: PagingData<People>) : Event()
        
        object ShowError : Event()
    }
    
    sealed class Action {
        
        class OnClickFavourite(val name: String) : Action()
    }
    
    
}