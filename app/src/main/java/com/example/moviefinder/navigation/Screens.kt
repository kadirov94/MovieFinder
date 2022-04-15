package com.example.moviefinder.navigation

sealed class Screens(val route: String) {
    object HomeScreen: Screens(route = "Home")
    object FavoriteScreen: Screens(route = "Favorite")
    object SupportScreen: Screens(route = "Support")
}
