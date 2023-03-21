package com.jok.tvshows.network

import com.jok.tvshows.BuildConfig
import org.junit.Test
import retrofit2.Retrofit

class NetworkLayerTest {
    @Test
    fun testRetrofitInstance() {
        //Get Retrofit instance
        val instance: Retrofit = NetworkLayer.retrofit
        //Assert that the Retrofit instance's base url matches ours
        assert(instance.baseUrl().url().toString() == BuildConfig.BASE_URL)
    }
}