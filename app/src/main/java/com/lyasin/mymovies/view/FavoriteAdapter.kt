package com.lyasin.mymovies.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.lyasin.mymovies.R
import com.lyasin.mymovies.model.Movie

class FavoriteAdapter(private val movies: List<Movie>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

}