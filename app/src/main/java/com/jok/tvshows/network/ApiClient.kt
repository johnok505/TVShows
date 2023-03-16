package com.jok.tvshows.network

import com.jok.tvshows.BuildConfig
import com.jok.tvshows.model.TMDBResponse
import retrofit2.Response
import java.lang.Exception


class ApiClient(
    private val tvService: TVService
) {
    suspend fun getTVShowList(): SimpleResponse<TMDBResponse> {
        return simpleApiCall {
            tvService.getTVShowList(
                apiKey = BuildConfig.API_KEY,
                language = "en",
                page = 1
            )
        }
    }

    //simple api call that has exception handling and can be reused
    private inline fun <T> simpleApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }



}