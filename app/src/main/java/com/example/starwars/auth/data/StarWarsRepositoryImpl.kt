package com.example.starwars.auth.data

import androidx.paging.PagingData
import com.example.starwars.ui.fragments.StarWarsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsNetworkDataSource: StarWarsNetworkDataSource
) : StarWarsRepository {

    override suspend fun peoplesList(/*page: Int*/): Flow<PagingData<People>> {
        return starWarsNetworkDataSource.peoplesList(/*page*/)
    }


}