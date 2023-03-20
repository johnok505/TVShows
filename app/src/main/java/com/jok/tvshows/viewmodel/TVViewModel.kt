package com.jok.tvshows.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jok.tvshows.model.TVShowItem
import com.jok.tvshows.repository.TVRepository
import kotlinx.coroutines.launch

class TVViewModel: ViewModel()  {
    private val repository = TVRepository()

    //data will be published to UI through a LiveData that can be observed
    private val _tvShowListLiveData = MutableLiveData<List<TVShowItem>?>()
    val tvShowLiveData: LiveData<List<TVShowItem>?> = _tvShowListLiveData
    private val picturePath = "https://image.tmdb.org/t/p/w500"

    //fetch TV shows from back end
    fun getTVShowList() {
        viewModelScope.launch {
            val response = repository.getTVShowList()
            //map response to make a cleaner list of tv show items
            val tvShowItems = response?.results?.map {
                TVShowItem(it.name, picturePath + it.poster_path)
            }
            _tvShowListLiveData.postValue(tvShowItems)
        }
    }
}