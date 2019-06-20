package com.lyasin.mymovies.repository

import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.model.Movies
import com.lyasin.mymovies.prefs

interface FavoriteRepository {
    fun addFavorite(movie: Movie)
    fun removeFavorite(movie: Movie)
    fun allFavorites(): Movies?
}

class FavoriteRepositoryImpl : FavoriteRepository {
    override fun allFavorites(): Movies? {
        return prefs.favorites
    }

    override fun addFavorite(movie: Movie) {
        val movies = allFavorites() ?: Movies(arrayListOf())
        movies.list.add(movie)
        prefs.favorites = movies
    }

    override fun removeFavorite(movie: Movie) {
        val movies = allFavorites() ?: Movies(arrayListOf())
        movies.list.remove(movie)
        prefs.favorites = movies
    }
}