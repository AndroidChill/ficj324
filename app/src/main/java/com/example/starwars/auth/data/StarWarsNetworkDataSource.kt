package com.example.starwars.auth.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.starwars.PeoplePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StarWarsNetworkDataSource @Inject constructor(
    private val starWarsApiService: StarWarsApiService
) {

     fun peoplesList (/*page: Int*/): Flow<PagingData<People>> {
        val source = PeoplePagingSource(starWarsApiService::getListPeoples)
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                source
            }
        ).flow
    }

}