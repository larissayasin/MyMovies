package com.lyasin.mymovies.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.lyasin.mymovies.model.Movie
import org.koin.core.KoinComponent
import org.koin.core.inject


class TopRatedMoviesKeyedDataSourceFactory : DataSource.Factory<Int, Movie>(){

    private val itemLiveDataSource = MutableLiveData<TopRatedMoviesKeyedDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val itemDataSource : TopRatedMoviesKeyedDataSource = getKoinInstance()
        itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<TopRatedMoviesKeyedDataSource> {
        return itemLiveDataSource
    }

    private inline fun <reified T : Any> getKoinInstance(): T {
        return object : KoinComponent {
            val value: T by inject()
        }.value
    }
}