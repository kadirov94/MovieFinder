package com.example.moviefinder.vm

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviefinder.model.Movie
import com.example.moviefinder.model.Result
import com.example.moviefinder.remote.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(): ViewModel() {

    var movieListResponse:List<Result> by mutableStateOf(listOf())

    @ExperimentalMaterialApi
    fun getMovie(){
        val retrofitMovie = ApiInterface.create().getMovie(
            "f7d961068463360d52010e12bce4204b",
            "ru"
        )
        retrofitMovie.enqueue(object: Callback<Movie> {

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val movie = response.body()?.results
                if (movie!= null) {
                    movieListResponse = movie.toMutableList()
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}