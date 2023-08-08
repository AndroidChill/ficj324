package com.example.starwars.ui.fragments

import com.example.starwars.auth.data.ListStarWarsResponse
import javax.inject.Inject

class StarWarsUseCase @Inject constructor(private val repository: StarWarsRepository) {
    
    suspend fun peoplesList(/*page: Int*/): ListStarWarsResponse = repository.peoplesList(/*page*/)

}