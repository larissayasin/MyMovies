package com.lyasin.mymovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.lyasin.mymovies.R
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.util.buildPosterUrl
import com.lyasin.mymovies.viewmodel.FavoriteMovieViewModel
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var movie: Movie
    private val vm: FavoriteMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val moshi = Moshi.Builder().build()
        movie = moshi.adapter(Movie::class.java).fromJson(intent.getStringExtra("movie"))

        tv_details_title.text = movie.title
        tv_details_overview.text = movie.overview
        Glide.with(this).load(movie.posterPath?.buildPosterUrl()).into(iv_details_poster)
        favoriteButton()
        bt_details_favorite.setOnClickListener {
            if (vm.isMovieFavorite(movie)) {
                vm.removeFavorite(movie)
            } else {
                vm.addFavorite(movie)
            }
            favoriteButton()
        }
    }

    private fun favoriteButton() {
        if (vm.isMovieFavorite(movie)) {
            bt_details_favorite.text = getString(R.string.remove_from_favorites)
            bt_details_favorite.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark, this.theme))
        } else {
            bt_details_favorite.text = getString(R.string.add_to_favorites)
            bt_details_favorite.setBackgroundColor(resources.getColor(R.color.colorAccent, this.theme))
        }
    }
}
