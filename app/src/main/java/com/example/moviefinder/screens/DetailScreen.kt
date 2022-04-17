package com.example.moviefinder.screens

import android.telecom.Call
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moviefinder.R
import com.example.moviefinder.model.Result
import com.example.moviefinder.navigation.Screens


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun DetailScreen(movieListReal: List<Result>) {
    val movieList = movieListReal
    Box(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current
        //val scrollState = rememberScrollState()
        LazyColumn {
            items(movieList.size, itemContent = {
                ItemList(content = movieList[it])
                //Toast.makeText(context, movieList.toString(), Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ItemList(content: Result) {
    val context = LocalContext.current
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        Row {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w1280/" + if (content.poster_path == null) content.backdrop_path else content.poster_path,
                contentDescription = null,
                Modifier
                    .padding(8.dp)
                    .width(160.dp)
                    .height(255.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds,
            )
            Column {
                Text(
                    text = content.title,
                    Modifier
                        .padding(start = 10.dp, top = 10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
                Text(
                    text = "Жанр: " + content.genre_ids.toString(),
                    Modifier
                        .padding(start = 10.dp, top = 3.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
                Text(
                    text = "Описание: " + if (content.overview.isEmpty()) "Описании нет, но вы держитесь" else content.overview,
                    Modifier
                        .padding(start = 7.dp, top = 3.dp, bottom = 30.dp),
                    fontSize = 12.sp,
                    maxLines = 8,
                    overflow = TextOverflow.Visible,
                )
            }
        }
        IconButton(
            onClick = {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 10.dp, end = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.favorite),
                contentDescription = "",
                Modifier.clip(
                    RoundedCornerShape(25.dp)
                )
            )
        }
    }
}