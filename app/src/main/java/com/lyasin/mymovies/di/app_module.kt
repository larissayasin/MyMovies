package com.lyasin.mymovies.di

import com.lyasin.mymovies.repository.*
import com.lyasin.mymovies.viewmodel.FavoriteMovieViewModel
import com.lyasin.mymovies.viewmodel.PopularMovieViewModel
import com.lyasin.mymovies.viewmodel.TopRatedMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    viewModel { PopularMovieViewModel(get()) }
    viewModel { TopRatedMovieViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get()) }

    single<MovieRepository>(createdAtStart = true) { MovieRepositoryImpl(get()) }
    single<FavoriteRepository>(createdAtStart = true) { FavoriteRepositoryImpl() }
    single { PopularMoviesKeyedDataSource(get()) }
    factory { PopularMoviesKeyedDataSourceFactory() }
    single { TopRatedMoviesKeyedDataSource(get()) }
    factory { TopRatedMoviesKeyedDataSourceFactory() }
}

val movieApp = listOf(remoteModule, movieModule)