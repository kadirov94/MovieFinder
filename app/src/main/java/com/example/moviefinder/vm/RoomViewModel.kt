package com.example.moviefinder.vm

import android.app.Application
import androidx.lifecycle.*
import com.example.moviefinder.model.MovieModel
import com.example.moviefinder.model.Result
import com.example.moviefinder.roomdb.RoomAppDb

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    var movieList: List<MovieModel> = listOf()
    var movieFavoriteList: MutableList<MovieModel> = mutableListOf()
    var movieDao = RoomAppDb.getAppDataBase(getApplication())?.movieDao()

    fun getAllMovie() {
        val list = movieDao?.getAllMovie()
        if (list != null) {
            movieList = list
        }
    }

    fun insertMovieList(list: List<Result>) {
       val newList = mutableListOf<MovieModel>()
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
        movieDao?.insertMovieList(list)
    }

    fun updateToFavorite(item: MovieModel){
        movieDao?.updateMovie(item)
        val list = movieDao?.getAllMovie()
        if (list != null) movieList = list
    }

    fun deleteFromFavorite(item: MovieModel){
        movieDao?.updateMovie(item)
        val list = movieDao?.getAllMovie()
        if (list != null) movieList = list
    }

    fun getFavorites(): MutableList<MovieModel>{
        val list = movieDao?.getAllMovie()
        if (list != null) {
            list.forEach{
                if (it.isFavorite == 1)
                movieFavoriteList.add(it)
            }
        }
        return movieFavoriteList
    }
}