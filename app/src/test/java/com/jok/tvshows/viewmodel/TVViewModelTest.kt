package com.jok.tvshows.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.jok.tvshows.MainCoroutineRule
import com.jok.tvshows.getOrAwaitValueTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TVViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //Main dispatcher doesn't exist in test package (no real app built, just running on JVM)
    //Setting a rule to allow coroutines to run
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: TVViewModel

    @Before
    fun setUp() {
        viewModel = TVViewModel()
    }

    @Test
    fun `fetching tv shows does not return null`() {
        viewModel.getTVShowList()
        val value = viewModel.tvShowLiveData.getOrAwaitValueTest()
        assertThat(value).isNotNull()
    }

    @Test
    fun `exactly twenty tv shows are returned on top twenty call`() {
        viewModel.getTVShowList()
        val value = viewModel.tvShowLiveData.getOrAwaitValueTest()
        assertThat(value?.size).isEqualTo(20)
    }
}