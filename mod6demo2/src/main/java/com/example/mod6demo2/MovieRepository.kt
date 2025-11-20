package com.example.mod6demo2

class MovieRepository(
    private val movieDAO: MovieDAO
) {

    fun addMovie(movie: Movie): Long {
        return movieDAO.insert(movie = movie)
    }

    fun getAllMovies(): List<Movie> {
        return movieDAO.findAll()
    }

}