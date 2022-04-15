package com.example.moviefinder.vm

import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviefinder.model.Movie
import com.example.moviefinder.model.Result
import com.example.moviefinder.remote.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(): ViewModel() {

    val movieList: MutableLiveData<MutableList<Result>> = MutableLiveData()
    var listMovie = listOf<Result>()

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
                    movieList.value = movie.toMutableList()
                    listMovie = movie
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}