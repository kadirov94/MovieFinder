package com.example.moviefinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviefinder.model.MovieModel
import com.example.moviefinder.navigation.Navigation
import com.example.moviefinder.ui.theme.MovieFinderTheme
import com.example.moviefinder.vm.MovieViewModel
import com.example.moviefinder.vm.RoomViewModel

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieFinderTheme {
                val mainViewModel: MovieViewModel = viewModel()
                val roomViewModel: RoomViewModel = viewModel()
                mainViewModel.getMovie()
                roomViewModel.insertMovieList(mainViewModel.movieListResponse)
                Surface(color = MaterialTheme.colors.background) {
                    //Toast.makeText(this, roomViewModel.mMovieList.value.toString(), Toast.LENGTH_SHORT).show()
                    Navigation(roomViewModel.movieList)
                }
            }
        }
    }
}