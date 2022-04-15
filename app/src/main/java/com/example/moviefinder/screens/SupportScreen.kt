package com.example.moviefinder.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SupportScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Здесь будет какая то  информация", textAlign = TextAlign.Center)
    }
}