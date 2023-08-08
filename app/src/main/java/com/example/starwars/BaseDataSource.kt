package com.example.starwars

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.starwars.auth.data.ListStarWarsResponse
import com.example.starwars.auth.data.People
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val BASE_STARTING_PAGE_INDEX = 1

class PeoplePagingSource(
    private val request: suspend (position: Int) -> Response<ListStarWarsResponse>,
) : PagingSource<Int, People>() {
    
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, People> {
        val position = params.key ?: BASE_STARTING_PAGE_INDEX
        
        return try {
            val response = request(position)
            val data = response.body()!!
            
            LoadResult.Page(
                data = data.results,
                prevKey = null,
                nextKey = position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
    
    override fun getRefreshKey(state: PagingState<Int, People>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
