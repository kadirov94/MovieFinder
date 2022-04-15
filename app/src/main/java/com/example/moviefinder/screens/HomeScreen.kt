package com.example.moviefinder.screens

import android.widget.Toast
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.bumptech.glide.manager.Lifecycle
import com.example.moviefinder.R
import com.example.moviefinder.model.Movie
import com.example.moviefinder.model.Result
import com.example.moviefinder.remote.ApiInterface
import com.example.moviefinder.repository.ItemMovie
import com.example.moviefinder.repository.MovieItem
import com.example.moviefinder.ui.theme.Shapes
import com.example.moviefinder.vm.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(movieViewModel: ViewModel?, viewModel: MovieViewModel = viewModel()) {
    val itemMovie = viewModel.listMovie
    val movieList2 = remember { itemMovie }
    Box(modifier = Modifier.fillMaxSize()){
        val context = LocalContext.current
        //val scrollState = rememberScrollState()
        LazyColumn{
            items(movieList2.size, itemContent = {
                ItemList(content = movieList2[it])
                Toast.makeText(context, movieList2.toString(), Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ItemList(content: Result) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(270.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        onClick = {
            Toast.makeText(context, "Details", Toast.LENGTH_SHORT).show()
        }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            Row {
                Image(
                    painter = painterResource(id = content.poster_path.toInt()),
                    contentDescription = "",
                    Modifier
                        .padding(8.dp)
                        .width(160.dp)
                        .height(255.dp)
                )
                Column {
                    Text(
                        text = content.title,
                        Modifier
                            .padding(start = 10.dp, top = 10.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Жанр: "+content.genre_ids.toString(),
                        Modifier
                            .padding(start = 10.dp, top=10.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Описание: "+content.overview,
                        Modifier
                            .padding(start = 7.dp, top=10.dp),
                        fontSize = 12.sp,
                        maxLines = 10
                    )
                }
            }
            IconButton(onClick = {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 10.dp, end = 20.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.favorite), contentDescription = "", Modifier.clip(
                    RoundedCornerShape(25.dp)))
            }
        }
    }
}