package com.jok.tvshows.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jok.tvshows.model.TMDBResponse
import com.jok.tvshows.repository.TVRepository
import kotlinx.coroutines.launch

class TVViewModel: ViewModel()  {
    private val repository = TVRepository()
    private val _tvShowListLiveData = MutableLiveData<TMDBResponse?>()
    val tvShowLiveData: LiveData<TMDBResponse?> = _tvShowListLiveData

    //fetch TV shows from back end
    fun getTVShowList() {
        viewModelScope.launch {
            val response = repository.getTVShowList()
            _tvShowListLiveData.postValue(response)
        }
    }
}