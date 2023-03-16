package com.jok.tvshows.repository

import android.content.Context
import com.jok.tvshows.model.TMDBResponse
import com.jok.tvshows.network.NetworkLayer

class TVRepository {

    suspend fun getTVShowList(): TMDBResponse? {

        val request = NetworkLayer.apiClient.getTVShowList()

        if (request.failed) {
            return null
        }
        if (!request.isSuccessful) {
            return null
        }
        return request.body
    }
}