package com.sujitmo.movieapp_kotlin_mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.sujitmo.movieapp_kotlin_mvvm.data.api.TheMovieDBInterface
import com.sujitmo.movieapp_kotlin_mvvm.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}