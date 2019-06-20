package com.lyasin.mymovies.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.lyasin.mymovies.R
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.util.DiffUtilCallBack

class MoviePagedAdapter : PagedListAdapter<Movie, MovieViewHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder:MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}