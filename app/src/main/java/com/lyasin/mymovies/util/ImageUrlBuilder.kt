package com.lyasin.mymovies.util

import com.lyasin.mymovies.api.ApiConfig

fun String.buildPosterUrl(): String {
    return ApiConfig.POSTER_URL + this + "?api_key=" + ApiConfig.API_KEY
}

fun String.buildBackdropUrl(): String {
    return ApiConfig.BACKDROP_URL + this + "?api_key=" + ApiConfig.API_KEY
}

