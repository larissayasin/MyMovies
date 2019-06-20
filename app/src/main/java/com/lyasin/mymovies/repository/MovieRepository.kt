package com.lyasin.mymovies.repository

import com.lyasin.mymovies.api.ApiConfig
import com.lyasin.mymovies.api.MovieApi
import com.lyasin.mymovies.model.Movies
import io.reactivex.Observable

interface MovieRepository{

    fun popular(page  : Int) : Observable<Movies>
    fun topRated(page  : Int) : Observable<Movies>
}
class MovieRepositoryImpl(private val api : MovieApi): MovieRepository {
    override fun popular(page: Int): Observable<Movies> {
        return api.popular( ApiConfig.API_KEY, page)
    }

    override fun topRated(page: Int): Observable<Movies> {
        return api.popular( ApiConfig.API_KEY, page)
    }
}