package com.lyasin.mymovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.repository.PopularMoviesKeyedDataSource
import com.lyasin.mymovies.repository.PopularMoviesKeyedDataSourceFactory
import com.lyasin.mymovies.util.AbstractEvent

class TopRatedMovieViewModel ( factory: PopularMoviesKeyedDataSourceFactory ): ViewModel(){
    var networkStateLiveData: LiveData<AbstractEvent<Void>>? = null

    var movieList: LiveData<PagedList<Movie>>

    private var liveDataSource: LiveData<PopularMoviesKeyedDataSource> = factory.getItemLiveDataSource()

    init {
        networkStateLiveData = Transformations.switchMap(
            liveDataSource
        ) { input -> input!!.networkEvent }

        val pagedListConfig = PagedList.Config.Builder().setEnablePlaceholders(true)
            .setPageSize(20)
            .build()

        movieList = LivePagedListBuilder(factory, pagedListConfig).build()
    }
}