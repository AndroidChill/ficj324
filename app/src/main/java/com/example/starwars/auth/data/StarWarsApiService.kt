package com.example.starwars.auth.data

import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApiService {

    @GET("people/?page=1")
    suspend fun getListPeoples(/*@Query("page") page: Int*/): ListStarWarsResponse
}

data class ListStarWarsResponse(
    val peoples: List<People>
)

@Serializable
data class People(
    val name: String,
    val gender: String,
    val starships: List<String>
)

