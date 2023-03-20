package com.jok.tvshows.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jok.tvshows.R
import com.jok.tvshows.model.TVShowItem
import com.squareup.picasso.Picasso

class TVAdapter(private val tvShowList: List<TVShowItem>) : RecyclerView.Adapter<TVAdapter.TVViewHolder>() {

    class TVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.itemImageView)
        val titleView: TextView = itemView.findViewById(R.id.itemTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.tv_show_item,
            parent,
            false
        )
        return TVViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val tvShow = tvShowList[position]
        Picasso.get().load(tvShow.picture).into(holder.imageView)
        holder.titleView.text = tvShow.name
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}