package com.example.moviefinder.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviefinder.model.MovieModel

@Database(entities = [MovieModel::class], version = 1)
abstract class RoomAppDb: RoomDatabase() {

    abstract fun movieDao(): MovieDao?

    companion object {
        private var INSTANCE: RoomAppDb? = null

        fun getAppDataBase(context: Context): RoomAppDb? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext, RoomAppDb::class.java, "AppBd")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }
}