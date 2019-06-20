package com.lyasin.mymovies.api

import com.lyasin.mymovies.model.Movies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun popular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Observable<Movies>


    @GET("movie/top_rated")
    fun topRated(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Observable<Movies>
}