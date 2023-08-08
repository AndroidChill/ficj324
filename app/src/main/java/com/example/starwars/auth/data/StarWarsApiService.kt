package com.example.starwars.auth.data

import kotlinx.serialization.Serializable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApiService {

    @GET("people/?")
    suspend fun getListPeoples(@Query("page") page: Int): Response<ListStarWarsResponse>
}

data class ListStarWarsResponse(
    val results: List<People>
)

@Serializable
data class People(
    val name: String,
    val gender: String,
    val starships: List<String>
)

