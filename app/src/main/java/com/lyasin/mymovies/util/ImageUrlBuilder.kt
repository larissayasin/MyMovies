package com.lyasin.mymovies.util

import com.lyasin.mymovies.api.ApiConfig

fun String.buildPosterUrl(): String {
    return ApiConfig.POSTER_URL + this + "?api_key=" + ApiConfig.API_KEY
}

