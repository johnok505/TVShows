package com.jok.tvshows.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {
    private val moshi = Moshi.Builder().addLast(
        com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val tvService: TVService by lazy {
        retrofit.create(TVService::class.java)
    }

    val apiClient = ApiClient(tvService)

}