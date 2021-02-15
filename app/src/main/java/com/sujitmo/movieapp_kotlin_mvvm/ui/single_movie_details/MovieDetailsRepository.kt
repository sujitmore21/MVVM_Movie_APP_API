package com.sujitmo.movieapp_kotlin_mvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.sujitmo.movieapp_kotlin_mvvm.data.api.TheMovieDBInterface
import com.sujitmo.movieapp_kotlin_mvvm.data.repository.MovieDetailsNetworkDataSource
import com.sujitmo.movieapp_kotlin_mvvm.data.repository.NetworkState
import com.sujitmo.movieapp_kotlin_mvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}