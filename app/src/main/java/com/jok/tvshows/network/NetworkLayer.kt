package com.jok.tvshows.network

import com.jok.tvshows.BuildConfig
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {
    private val moshi = Moshi.Builder().addLast(
        com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val tvService: TVService by lazy {
        retrofit.create(TVService::class.java)
    }

    val apiClient = ApiClient(tvService)

}