package com.lyasin.mymovies.model

import com.squareup.moshi.Json

data class Movie(
    val id: Long,
    val title: String,
    val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "vote_average") val voteAvarege: Double?,
    @Json(name = "release_date") val releaseDate: String?
)