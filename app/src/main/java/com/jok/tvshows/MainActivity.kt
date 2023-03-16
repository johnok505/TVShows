package com.jok.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.jok.tvshows.viewmodel.TVViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TVViewModel by lazy {
        ViewModelProvider(this)[TVViewModel::class.java]
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getTVShowList()
        viewModel.tvShowLiveData.observe(this){ TVShowsResponse ->
            if (TVShowsResponse == null) {
                //short toast message in case we fail to retrieve data
                Toast.makeText(this, "error retrieving data", Toast.LENGTH_SHORT).show()
                return@observe
            }
            Log.d("TAG", TVShowsResponse.toString())
        }
    }
}