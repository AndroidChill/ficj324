package com.example.starwars.auth.data

import javax.inject.Inject

class StarWarsNetworkDataSource @Inject constructor(
    private val starWarsApiService: StarWarsApiService
) {

    suspend fun peoplesList (/*page: Int*/) = starWarsApiService.getListPeoples(/*page*/)

}