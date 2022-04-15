package com.example.moviefinder.remote

import com.example.moviefinder.BuildConfig
import com.example.moviefinder.model.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    //https://api.themoviedb.org/3/movie/popular?api_key=f7d961068463360d52010e12bce4204b&language=ru
    @GET("3/movie/popular")
    fun getMovie(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
    ): Call<Movie>

    companion object {

        val BASE_URL = "https://api.themoviedb.org/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().also { client ->
                    if(BuildConfig.DEBUG){
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
                        client.addInterceptor(logging)
                    }
                }
                    .build()
                )
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}