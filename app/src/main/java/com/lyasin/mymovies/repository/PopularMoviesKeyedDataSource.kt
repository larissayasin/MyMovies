package com.lyasin.mymovies.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.lyasin.mymovies.model.Movie
import com.lyasin.mymovies.util.ErrorEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularMoviesKeyedDataSource(private val repository: MovieRepository) : PageKeyedDataSource<Int, Movie>() {
    private var currentPage = 1
    val networkEvent = MutableLiveData<ErrorEvent>()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        networkEvent.postValue(ErrorEvent())
        val d = repository.popular(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ moviesResponse ->
                    callback.onResult(moviesResponse.list, 0, 2)
                    networkEvent.postValue(ErrorEvent())
                }, { error ->
                    networkEvent.postValue(ErrorEvent(error = error))
                })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        currentPage++
        networkEvent.postValue(ErrorEvent())
        val d = repository.popular(currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ moviesResponse ->
                    callback.onResult(moviesResponse.list, currentPage)
                    networkEvent.postValue(ErrorEvent())
                }, { error ->
                    networkEvent.postValue(ErrorEvent(error = error))
                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

}