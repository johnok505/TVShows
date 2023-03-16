package com.jok.tvshows.network

import com.jok.tvshows.model.TMDBResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVService {

    @GET("tv/top_rated")
    suspend fun getTVShowList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<TMDBResponse>

}