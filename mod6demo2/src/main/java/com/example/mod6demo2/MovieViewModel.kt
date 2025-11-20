package com.example.mod6demo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    init {
        val movie1 = Movie(
            title = "Les évadés",
            year = 1994,
            genre = "Drame",
            director = "Frank Darabont"
        )
        val movie2 = Movie(
            title = "'La Ligne verte",
            year = 1999,
            genre = "Drame",
            director = "Frank Darabont"
        )
        val movie3 = Movie(
            title = "Forrest Gump",
            year = 1994,
            genre = "Drame",
            director = "Robert Zemeckis"
        )

        movieRepository.addMovie(movie1)
        movieRepository.addMovie(movie2)
        movieRepository.addMovie(movie3)

        _movies.value = movieRepository.getAllMovies()
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                val movieDbHelper = MovieDbHelper(application.applicationContext)

                return MovieViewModel(
                    MovieRepository(
                        MovieDAO(
                            dbr = movieDbHelper.readableDatabase,
                            dbw = movieDbHelper.writableDatabase
                        )
                    )
                ) as T
            }
        }
    }

}