package com.lyasin.mymovies.viewmodel

import androidx.lifecycle.ViewModel
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.repository.FavoriteRepository

class FavoriteMovieViewModel (private val movieRepository: FavoriteRepository ): ViewModel(){

    fun addFavorite(movie : Movie){
        movieRepository.addFavorite(movie)
    }

    fun removeFavorite(movie : Movie){
        movieRepository.removeFavorite(movie)
    }

    fun all(){
        movieRepository.allFavorites()
    }
}