package com.example.moviefinder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "movieData", indices = [Index(value = ["title"], unique = true)])
data class MovieModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "backdrop_path")
    var backdrop_path: String?,

//    @ColumnInfo(name = "genre")
//    var genre: String?,

    @ColumnInfo(name = "overview")
    var overview: String?,

    @ColumnInfo(name = "release_date")
    var release_date: String?,

    @ColumnInfo(name = "poster_path")
    var poster_path: String?,

    @ColumnInfo(name = "vote_average")
    var vote_average: Double?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Int = 0,
)