package com.example.moviefinder.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.moviefinder.R
import com.example.moviefinder.model.MovieModel
import com.example.moviefinder.navigation.Screens
import com.example.moviefinder.vm.RoomViewModel

@Composable
fun DetailScreen() {
    //val movieList = movieListReal
    Box(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        Text(text = "Text")
        //val scrollState = rememberScrollState()
    }
}