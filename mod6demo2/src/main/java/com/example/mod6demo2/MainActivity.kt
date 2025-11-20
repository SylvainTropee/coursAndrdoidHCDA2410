package com.example.mod6demo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6demo2.ui.theme.CoursAndroidHCDA2410Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidHCDA2410Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList(
    movieViewModel: MovieViewModel = viewModel(factory = MovieViewModel.Factory),
    modifier: Modifier = Modifier) {

    val movies by movieViewModel.movies.collectAsState()

    LazyColumn() {
        items(movies){
            Text(it.toString())
        }
    }

}