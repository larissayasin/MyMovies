package com.lyasin.mymovies.view

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lyasin.mymovies.model.Movie
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) {
        itemView.tv_movie_title.text = movie.title
        itemView.tv_movie_vote.text = movie.voteAvarege.toString()
        itemView.tv_movie_release_date.text = movie.releaseDate

        itemView.setOnClickListener {
            val i = Intent(itemView.context, DetailsActivity::class.java)
            val moshi = Moshi.Builder().build()
            i.putExtra("movie", moshi.adapter(Movie::class.java).toJson(movie))
            itemView.context.startActivity(i)
        }
    }
}