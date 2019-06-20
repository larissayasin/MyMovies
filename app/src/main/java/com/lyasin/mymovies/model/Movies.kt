package com.lyasin.mymovies.model

import com.squareup.moshi.Json

data class Movies(
    @Json(name = "results") val list: ArrayList<Movie>
)