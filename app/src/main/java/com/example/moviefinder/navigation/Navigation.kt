package com.example.moviefinder.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviefinder.screens.FavoriteScreen
import com.example.moviefinder.screens.HomeScreen
import com.example.moviefinder.R
import com.example.moviefinder.model.Result
import com.example.moviefinder.screens.SupportScreen
import com.example.moviefinder.vm.MovieViewModel

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(movieListReal: List<Result>) {
    val movieViewModel: ViewModel?
    val viewModel: MovieViewModel = viewModel()
    val navController = rememberNavController()
    val bottomList = listOf("Home", "Favorite", "Support")
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                contentPadding = PaddingValues(start = 20.dp, top = 20.dp, bottom = 20.dp),
                content = {
                    Row {
                        Text(
                            text = "Movie",
                            fontSize = 30.sp,
                        )
                        Text(
                            text = "Finder",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                contentPadding = PaddingValues(start = 20.dp, top = 20.dp, bottom = 20.dp),
                content = {
                    bottomList.forEach { screen ->
                        BottomNavigationItem(
                            selected = false,
                            onClick = { navController.navigate(screen) },
                            label = { Text(text = screen, fontSize = 10.sp) },
                            icon = {
                                Image(
                                    painter = painterResource(id = R.drawable.home),
                                    contentDescription = "screen"
                                )
                            },
                        )
                    }
                }
            )
            /*BottomNavigation(backgroundColor = Color.White) {
                bottomList.forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = { navController.navigate(screen) },
                        label = { Text(text = screen) },
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.home),
                                contentDescription = "screen")
                        },
                    )
                }
            }*/
        }
    ) {
        NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
            composable(route = "Home") {
                HomeScreen(movieListReal, navController)
            }
            composable("Favorite") {
                FavoriteScreen(movieListReal,)
            }
            composable("Support") {
                SupportScreen()
            }
        }
    }
}