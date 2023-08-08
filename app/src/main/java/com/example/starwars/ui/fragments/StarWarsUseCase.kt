package com.example.starwars.ui.fragments

import androidx.paging.PagingData
import com.example.starwars.auth.data.ListStarWarsResponse
import com.example.starwars.auth.data.People
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StarWarsUseCase @Inject constructor(private val repository: StarWarsRepository) {
    
    suspend fun peoplesList(/*page: Int*/): Flow<PagingData<People>> = repository.peoplesList(/*page*/)

}