package com.example.starwars.ui.fragments

import androidx.paging.PagingData
import com.example.starwars.auth.data.ListStarWarsResponse
import com.example.starwars.auth.data.People
import kotlinx.coroutines.flow.Flow

interface StarWarsRepository {
    
    suspend fun peoplesList(/*page: Int*/): Flow<PagingData<People>>

}
