package com.example.starwars.auth.data

import com.example.starwars.ui.fragments.StarWarsRepository
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsNetworkDataSource: StarWarsNetworkDataSource
) : StarWarsRepository {

    override suspend fun peoplesList(/*page: Int*/): ListStarWarsResponse {
        return starWarsNetworkDataSource.peoplesList(/*page*/)
    }


}