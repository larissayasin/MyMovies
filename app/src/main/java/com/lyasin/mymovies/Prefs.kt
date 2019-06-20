package com.lyasin.mymovies

import android.content.Context
import android.content.SharedPreferences
import com.lyasin.mymovies.model.Movies
import com.squareup.moshi.Moshi


class Prefs(context: Context) {
    private val PREFS_FILENAME = "com.lyasin.mymovies.prefs"
    private val FAVORITES = "favorites"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var favorites: Movies?
        get() {
            val moshi = Moshi.Builder().build()
            return if (prefs.getString(FAVORITES, "").isNullOrEmpty()){
                Movies(arrayListOf())
            }else {
                moshi.adapter(Movies::class.java).fromJson(prefs.getString(FAVORITES, ""))
            }
        }
        set(value) {
            val moshi = Moshi.Builder().build()
            return prefs.edit().putString(FAVORITES, moshi.adapter(Movies::class.java).toJson(value)).apply()
        }
}
