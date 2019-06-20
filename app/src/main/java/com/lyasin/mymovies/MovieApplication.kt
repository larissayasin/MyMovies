package com.lyasin.mymovies

import android.app.Application
import com.lyasin.mymovies.di.movieApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

val prefs: Prefs by lazy {
    MovieApplication.prefs!!
}

class MovieApplication : Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            modules(movieApp)
        }
    }
}