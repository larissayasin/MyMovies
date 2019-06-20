package com.lyasin.mymovies.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.util.AbstractEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TopRatedMoviesKeyedDataSource(private val repository: MovieRepository) : PageKeyedDataSource<Int, Movie>() {
    private var currentPage = 1
    val networkEvent = MutableLiveData<AbstractEvent<Void>>()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        networkEvent.postValue(AbstractEvent(isLoading = true))
        val d = repository.topRated(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ moviesResponse ->
                    callback.onResult(moviesResponse.list, 0, 2)
                    networkEvent.postValue(AbstractEvent(isLoading = false))
                }, { error ->
                    networkEvent.postValue(AbstractEvent(error = error))
                })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        currentPage++
        networkEvent.postValue(AbstractEvent(isLoading = true))
        val d = repository.topRated(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ moviesResponse ->
                    callback.onResult(moviesResponse.list, currentPage)
                    networkEvent.postValue(AbstractEvent(isLoading = false))
                }, { error ->
                    networkEvent.postValue(AbstractEvent(error = error))
                })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

}