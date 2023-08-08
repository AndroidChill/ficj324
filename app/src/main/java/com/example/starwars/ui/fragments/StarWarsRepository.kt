package com.example.starwars.ui.fragments

import com.example.starwars.auth.data.ListStarWarsResponse

interface StarWarsRepository {
    
    suspend fun peoplesList(/*page: Int*/): ListStarWarsResponse

}
