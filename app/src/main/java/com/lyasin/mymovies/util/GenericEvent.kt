package com.lyasin.mymovies.util

open class AbstractEvent<T>(
        val isLoading: Boolean = false,
        val error: Throwable? = null,
        val data: T? = null)