package com.example.moviefinder.roomdb

import androidx.room.*
import com.example.moviefinder.model.MovieModel

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieData ORDER BY id DESC")
    fun getAllMovie(): List<MovieModel>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovieList(newsEntity: MutableList<MovieModel>?)

    @Update
    fun updateMovie(MovieModel: MovieModel?)
}