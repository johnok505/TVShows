package com.jok.tvshows

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jok.tvshows.adapter.TVAdapter
import com.jok.tvshows.viewmodel.TVViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TVViewModel by lazy {
        ViewModelProvider(this)[TVViewModel::class.java]
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up the recycler view
        recyclerView = findViewById(R.id.tvRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //tell view model to fetch data
        viewModel.getTVShowList()
        //observe livedata and populate recycler view when api call completed
        viewModel.tvShowLiveData.observe(this){ tvShowItems ->
            if (tvShowItems == null) {
                //short toast message in case we fail to retrieve data
                Toast.makeText(this, "error retrieving data", Toast.LENGTH_SHORT).show()
                return@observe
            }

            //add data to the recycler view
            recyclerView.adapter = TVAdapter(tvShowItems)
        }
    }
}