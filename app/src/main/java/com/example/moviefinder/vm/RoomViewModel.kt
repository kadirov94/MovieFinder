package com.example.moviefinder.vm

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.moviefinder.model.MovieModel
import com.example.moviefinder.model.Result
import com.example.moviefinder.remote.ApiInterface
import com.example.moviefinder.roomdb.RoomAppDb
import kotlinx.coroutines.launch

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    //val mMovieList: LiveData<List<MovieModel>> get() = movieList
    var movieList: List<MovieModel> = listOf()
    var userDao = RoomAppDb.getAppDataBase(getApplication())?.movieDao()
    //var listMovie: List<MovieModel> by mutableStateOf(listOf())

    fun getAllMovie() {
        val list = userDao?.getAllMovie()
        if (list != null) {
            movieList = list
        }
    }

    fun insertMovieList(list: List<Result>) {
       val newList = mutableListOf<MovieModel>()//(MovieModel(0,"5","5","5","5","5",5.5,0))
        for (i in 0 until list.size) {
            val it = list[i]
            newList.add(
                MovieModel(
                    0,
                    it.title,
                    it.backdrop_path,
                    //"1",
                    it.overview,
                    it.release_date,
                    it.poster_path,
                    it.vote_average,
                    0))
        }
        insertListToDb(newList)
        getAllMovie()
    }

    fun insertListToDb(list: MutableList<MovieModel>){
        userDao?.insertMovieList(list)
    }
}