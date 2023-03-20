package com.jok.tvshows

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jok.tvshows.adapter.TVAdapter
import com.jok.tvshows.model.TVShowItem
import com.jok.tvshows.viewmodel.TVViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: TVViewModel by lazy {
        ViewModelProvider(this)[TVViewModel::class.java]
    }

    private lateinit var tvShowList: List<TVShowItem>
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvAdapter: TVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up the recycler view
        recyclerView = findViewById(R.id.tvRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)

        //initiate filter button
        val filterButton = findViewById<Button>(R.id.filterButton)

        //disable filter button until data received
        filterButton.isEnabled = false

        //tell view model to fetch data
        viewModel.getTVShowList()
        //observe livedata and populate recycler view when api call completed
        viewModel.tvShowLiveData.observe(this){ tvShowItemsResponse ->
            if (tvShowItemsResponse == null) {
                //short toast message in case we fail to retrieve data
                Toast.makeText(this, "error retrieving data", Toast.LENGTH_SHORT).show()
                filterButton.isEnabled = false
                return@observe
            }
            tvShowList = tvShowItemsResponse

            updateRecyclerView()

            //enable filter button when data received
            filterButton.isEnabled = true
            filterButton.setOnClickListener {
                tvShowList = tvShowList.sortedBy { it.name }
                updateRecyclerView()
            }
        }
    }
    private fun updateRecyclerView() {
        tvAdapter = TVAdapter(tvShowList)
        recyclerView.adapter = tvAdapter
    }
}